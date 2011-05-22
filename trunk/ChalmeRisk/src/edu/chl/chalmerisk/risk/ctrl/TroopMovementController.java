package edu.chl.chalmerisk.risk.ctrl;
import edu.chl.chalmerisk.risk.core.ChalmeRisk;
import edu.chl.chalmerisk.risk.core.Country;
import edu.chl.chalmerisk.risk.core.TurnState;
import edu.chl.chalmerisk.risk.view.ViewBuilder;

public class TroopMovementController extends TurnState {
	
	private boolean firstCountrySelected;
	private Country moveFromCountry;
	private Country moveToCountry;
	private boolean isTroopMovementState;
	private boolean allowTroopMovement;
	
	
	public TroopMovementController(){
		firstCountrySelected = false;
		isTroopMovementState = false;
	}
	
	@Override
	public void setCountry(int id){
		if (!firstCountrySelected) {
			if(ChalmeRisk.map.getCountry(id).getTroops()<=1 && ChalmeRisk.map.getCountry(id).getOwner().equals(ChalmeRisk.round.getCurrentPlayer())){
				ChalmeRisk.infoModel.setWarningText("There are not enough troops for a troopmovement");
			}
			else if(ChalmeRisk.map.getCountry(id).getOwner().equals(ChalmeRisk.round.getCurrentPlayer())){
				firstCountrySelected = true;
				moveFromCountry = ChalmeRisk.map.getCountry(id);
				moveFromCountry.setSelected(true);
				ChalmeRisk.infoModel.setCorrectMoveText("You have marked the country to move troops from");
			}
			else{
				ChalmeRisk.infoModel.setWarningText("You can only move troops from your own country");
			}
		}
		else if(moveFromCountry.getOwner() == ChalmeRisk.map.getCountry(id).getOwner()){
				moveToCountry = ChalmeRisk.map.getCountry(id);
				if (moveFromCountry.hasNeighbour(id) == true) {
					firstCountrySelected = false;
					moveFromCountry.setSelected(false);
					if(allowTroopMovement){
						ChalmeRisk.movementModel.newMovement(moveFromCountry, moveToCountry);
						isTroopMovementState = true;
					}
					else{
						ChalmeRisk.infoModel.setWarningText("You can only move troops once every turn");
					}
				}
				else {
					ChalmeRisk.infoModel.setWarningText("You can only move troops to a neighbouring country");
				}
		}
		else{
			ChalmeRisk.infoModel.setWarningText("You can only move troops between your own countries");
			moveFromCountry.setSelected(false);
			moveFromCountry = null;
			firstCountrySelected = false;
		}
	}
	

	
	public void doMovement(int value, Country fromCountry, Country toCountry){
		fromCountry.setTroops(fromCountry.getTroops()-value);
		toCountry.setTroops(toCountry.getTroops()+value);
		if(isTroopMovementState == true){
			isTroopMovementState = false;
		}
	}
	
	public void notAllowTroopMovement (){
		allowTroopMovement=false;
	}
	
	public void allowTroopMovement(){
		allowTroopMovement=true;
	}
	

	

	/*
	public void doMovement(int value){
		firstSelectedCountry.setTroops(firstSelectedCountry.getTroops()-value);
		secondSelectedCountry.setTroops(secondSelectedCountry.getTroops()+value);
		ChalmeRisk.turn.changeState();
	}
	*/
}
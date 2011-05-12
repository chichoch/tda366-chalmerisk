package edu.chl.chalmerisk.risk.ctrl;
import javax.swing.JOptionPane;

import edu.chl.chalmerisk.risk.constants.Country;
import edu.chl.chalmerisk.risk.core.*;

public class TroopMovementController extends TurnState {
	
	private boolean firstCountrySelected;
	private Country firstSelectedCountry;
	private Country secondSelectedCountry;
	private boolean isTroopMovementState;
	
	
	public TroopMovementController(){
		firstCountrySelected = false;
		isTroopMovementState = false;
	}
	
	@Override
	public void setCountry(int id){
		if (!firstCountrySelected) {
			if(ChalmeRisk.map.getCountry(id).getTroops()<=1){
				ChalmeRisk.infoModel.setWarningText("There are not enough troops for a troopmovement");
			}
			else if(ChalmeRisk.map.getCountry(id).getOwner().equals(ChalmeRisk.round.getCurrentPlayer())){
				firstCountrySelected = true;
				firstSelectedCountry = ChalmeRisk.map.getCountry(id);	
			}
			else{
				ChalmeRisk.infoModel.setWarningText("You can only move troops from your own country");
			}
		}
		else {
			if(firstSelectedCountry.getOwner() == ChalmeRisk.map.getCountry(id).getOwner()){
				secondSelectedCountry = ChalmeRisk.map.getCountry(id);
				if (firstSelectedCountry.hasNeighbour(id) == true) {
					firstCountrySelected = false;
					ChalmeRisk.movement.newMovement(firstSelectedCountry, secondSelectedCountry);
					ChalmeRisk.movement.setVisible(true);
					isTroopMovementState = true;
				}
				else {
					ChalmeRisk.infoModel.setWarningText("You can only move troops to a neighbouring country");
				}
			}
			else{
				ChalmeRisk.infoModel.setWarningText("You can only move troops between your own countries");
				firstSelectedCountry = null;
				firstCountrySelected = false;
				}
		}
	}
	
	public void doMovement(int value, Country fromCountry, Country toCountry){
		fromCountry.setTroops(fromCountry.getTroops()-value);
		toCountry.setTroops(toCountry.getTroops()+value);
		if(isTroopMovementState == true){
			ChalmeRisk.turn.changeState();
			isTroopMovementState = false;
		}
	}
	/*
	public void doMovement(int value){
		firstSelectedCountry.setTroops(firstSelectedCountry.getTroops()-value);
		secondSelectedCountry.setTroops(secondSelectedCountry.getTroops()+value);
		ChalmeRisk.turn.changeState();
	}
	*/
}

package edu.chl.chalmerisk.risk.ctrl;
import javax.swing.JOptionPane;

import edu.chl.chalmerisk.risk.constants.Country;
import edu.chl.chalmerisk.risk.core.*;

public class TroopMovementController extends TurnState {
	
	private boolean firstCountrySelected;
	private Country firstSelectedCountry;
	private Country secondSelectedCountry;
	
	
	public TroopMovementController(){
		firstCountrySelected = false;
	}
	
	@Override
	public void setCountry(int id){
		if (!firstCountrySelected) {
			if(ChalmeRisk.map.getCountry(id).getTroops()<=1){
				JOptionPane.showMessageDialog(null, "För få trupper för att förflytta!");
			}
			else if(ChalmeRisk.map.getCountry(id).getOwner().equals(ChalmeRisk.round.getCurrentPlayer())){
				firstCountrySelected = true;
				firstSelectedCountry = ChalmeRisk.map.getCountry(id);
				JOptionPane.showMessageDialog(null, "Första landet markerat (" + ChalmeRisk.map.getCountry(id).getName() + ")" );	
			}
			else{
				JOptionPane.showMessageDialog(null, "Du måste förflytta trupper från ditt egna land" );
			}
		}
		else {
			if(firstSelectedCountry.getOwner() == ChalmeRisk.map.getCountry(id).getOwner()){
				secondSelectedCountry = ChalmeRisk.map.getCountry(id);
				if (firstSelectedCountry.hasNeighbour(id) == true) {
					JOptionPane.showMessageDialog(null, "Andra landet markerat (" + ChalmeRisk.map.getCountry(id).getName() + ")" );
					firstCountrySelected = false;
					ChalmeRisk.movement.newMovement(firstSelectedCountry, secondSelectedCountry);
					ChalmeRisk.movement.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Landet du vill förflytta trupper till måste vara ett grannland!");
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Du kan bara förflytta mellan dina egna länder");
				firstSelectedCountry = null;
				firstCountrySelected = false;
				}
		}
	}
	public void doMovement(int value){
		firstSelectedCountry.setTroops(firstSelectedCountry.getTroops()-value);
		secondSelectedCountry.setTroops(secondSelectedCountry.getTroops()+value);
		ChalmeRisk.turn.changeState();
	}
}

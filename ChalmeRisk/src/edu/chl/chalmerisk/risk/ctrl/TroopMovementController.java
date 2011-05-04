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
			if(Builder.map.getCountry(id).getTroops()<=1){
				JOptionPane.showMessageDialog(null, "För få trupper för att förflytta!");
			}
			else if(Builder.map.getCountry(id).getOwner().equals(Builder.round.getCurrentPlayer())){
				firstCountrySelected = true;
				firstSelectedCountry = Builder.map.getCountry(id);
				JOptionPane.showMessageDialog(null, "Första landet markerat (" + Builder.map.getCountry(id).getName() + ")" );	
			}
			else{
				JOptionPane.showMessageDialog(null, "Du måste förflytta trupper från ditt egna land" );
			}
		}
		else {
			if(firstSelectedCountry.getOwner() == Builder.map.getCountry(id).getOwner()){
				secondSelectedCountry = Builder.map.getCountry(id);
				if (firstSelectedCountry.hasNeighbour(id) == true) {
					JOptionPane.showMessageDialog(null, "Andra landet markerat (" + Builder.map.getCountry(id).getName() + ")" );
					firstCountrySelected = false;
					Builder.movement.newMovement(firstSelectedCountry, secondSelectedCountry);
					Builder.movement.setVisible(true);
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
		Builder.turn.changeState();
	}
}

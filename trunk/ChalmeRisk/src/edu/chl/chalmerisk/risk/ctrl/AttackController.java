package edu.chl.chalmerisk.risk.ctrl;

import javax.swing.JOptionPane;
import edu.chl.chalmerisk.risk.*;

import edu.chl.chalmerisk.risk.constants.Country;
import edu.chl.chalmerisk.risk.core.Builder;


public class AttackController {
	
	private Country attCountry;
	private Country defCountry;
	private boolean firstCountrySelected;
	private boolean takeOverCountry;
	
	//Constructor
	public AttackController() {
		takeOverCountry = false;
		firstCountrySelected = false;
	}
	
	public void setCountry(int id) {
		
		if (!firstCountrySelected) {
			if(Builder.map.getCountry(id).getTroops()<=1){
				JOptionPane.showMessageDialog(null, "För få trupper för att attackera!");
			}
			else{
				firstCountrySelected = true;
				attCountry = Builder.map.getCountry(id);
				JOptionPane.showMessageDialog(null, "Första landet markerat (" + Builder.map.getCountry(id).getName() + ")" );	
			}
			
		}
		else {
			if(attCountry.getOwner() != Builder.map.getCountry(id).getOwner()){
				defCountry = Builder.map.getCountry(id);	
				if (attCountry.hasNeighbour(id) == true) {
					JOptionPane.showMessageDialog(null, "Andra landet markerat (" + Builder.map.getCountry(id).getName() + ")" );
					firstCountrySelected = false;	
					Builder.attack.newAttack();
					Builder.attack.repaintTroops(attCountry.getTroops(), defCountry.getTroops());
					Builder.attack.setVisible(true);
					Builder.guiTest.update();
					//new Attack(attCountry, defCountry);
				}
				else {
					JOptionPane.showMessageDialog(null, "Landet du vill attackera måste vara ett grannland!");
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Du kan inte attackera ditt eget land");
				attCountry = null;
				firstCountrySelected = false;
			}
		}	 
	}
	
	public void startFight() {
		
		int i = Builder.diceC.getResult();
		//double i = Math.random()*10;
		if(i==1){
			attCountry.setTroops(attCountry.getTroops() - 1);
			Builder.attack.setStatusText("Defender killed 1 ");
		}
		else if(i==2){
			defCountry.setTroops(defCountry.getTroops() - 1);
			Builder.attack.setStatusText("Attacker killed 1 ");
		}
		else if(i==3){
			defCountry.setTroops(defCountry.getTroops() - 2);
			Builder.attack.setStatusText("Attacker killed 2 ");
		}
		else if(i==4){
			attCountry.setTroops(attCountry.getTroops() - 2);
			Builder.attack.setStatusText("Attacker killed 2 ");
		}
		else if(i==5){
			defCountry.setTroops(defCountry.getTroops() - 1);
			attCountry.setTroops(attCountry.getTroops() - 1);
			Builder.attack.setStatusText("Attacker and defender killed 1 ");
		}
		if(attCountry.getTroops() <= 1){
			Builder.attack.setDefenderWin();
		}
		if(defCountry.getTroops() <= 0){
			//fight.setVisible(false);
			Builder.attack.setAttackerWin();
			takeOverCountry = true;
		}
		Builder.attack.repaintTroops(attCountry.getTroops(), defCountry.getTroops());	
	}
	
	//When you click "Invade" or "Retreat".
	public void endFight() {
		Builder.attack.setVisible(false);
		if(takeOverCountry == true){
			defCountry.setOwner(attCountry.getOwner());
			attCountry.setTroops(attCountry.getTroops()-1);
			defCountry.setTroops(1);
		}
	}
}

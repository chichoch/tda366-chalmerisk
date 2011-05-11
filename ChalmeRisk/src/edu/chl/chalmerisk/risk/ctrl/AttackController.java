package edu.chl.chalmerisk.risk.ctrl;

import javax.swing.JOptionPane;
import edu.chl.chalmerisk.risk.constants.Country;
import edu.chl.chalmerisk.risk.core.*;



public class AttackController extends TurnState{
	
	private Country attCountry;
	private Country defCountry;
	private boolean firstCountrySelected;
	private boolean takeOverCountry;
	//TODO AttackTroops-1
	//Constructor
	public AttackController() {
		takeOverCountry = false;
		firstCountrySelected = false;
	}
	
	@Override
	public void setCountry(int id) {
		
		if (!firstCountrySelected) {
			if(ChalmeRisk.map.getCountry(id).getTroops()<=1){
				JOptionPane.showMessageDialog(null, "För få trupper för att attackera!");
			}
			else if(!ChalmeRisk.map.getCountry(id).getOwner().equals(ChalmeRisk.round.getCurrentPlayer())){
				JOptionPane.showMessageDialog(null, "Du måste attackera från ditt egna land" );	
			}
			else{
				firstCountrySelected = true;
				attCountry = ChalmeRisk.map.getCountry(id);
				JOptionPane.showMessageDialog(null, "Första landet markerat (" + ChalmeRisk.map.getCountry(id).getName() + ")" );	
			}
			
		}
		else {
			if(attCountry.getOwner() != ChalmeRisk.map.getCountry(id).getOwner()){
				defCountry = ChalmeRisk.map.getCountry(id);	
				if (attCountry.hasNeighbour(id) == true) {
					JOptionPane.showMessageDialog(null, "Andra landet markerat (" + ChalmeRisk.map.getCountry(id).getName() + ")" );
					firstCountrySelected = false;
					takeOverCountry = false;
					ChalmeRisk.attack.newAttack(attCountry, defCountry);
					ChalmeRisk.attack.repaintTroops(attCountry.getTroops()-1, defCountry.getTroops());
					ChalmeRisk.attack.setVisible(true);
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
		int i = ChalmeRisk.diceC.getResult(attCountry.getTroops(), defCountry.getTroops());
		//double i = (int) ((Math.random() * 2) + 1);;
		if(i==1){
			attCountry.setTroops(attCountry.getTroops() - 1);
			ChalmeRisk.attack.setStatusText("Defender killed 1 ");
		}
		else if(i==2){
			defCountry.setTroops(defCountry.getTroops() - 1);
			ChalmeRisk.attack.setStatusText("Attacker killed 1 ");
		}
		else if(i==3){
			if(defCountry.getTroops()==1){
				defCountry.setTroops(defCountry.getTroops() - 1);
				ChalmeRisk.attack.setStatusText("Attacker killed 2 ");
			}
			else{
				defCountry.setTroops(defCountry.getTroops() - 2);
				ChalmeRisk.attack.setStatusText("Attacker killed 2 ");
			}
		}
		else if(i==4){
			if(attCountry.getTroops()==1){
				attCountry.setTroops(attCountry.getTroops() - 1);
				ChalmeRisk.attack.setStatusText("Defender killed 1 ");
			}
			else{
				attCountry.setTroops(attCountry.getTroops() - 2);
				ChalmeRisk.attack.setStatusText("Defender killed 2 ");
			}
		}
		else if(i==5){
			defCountry.setTroops(defCountry.getTroops() - 1);
			attCountry.setTroops(attCountry.getTroops() - 1);
			ChalmeRisk.attack.setStatusText("Attacker and defender killed 1 ");
		}
		if(attCountry.getTroops() <= 1){
			ChalmeRisk.attack.setDefenderWin();
		}
		if(defCountry.getTroops() <= 0){
			//fight.setVisible(false);
			ChalmeRisk.attack.setAttackerWin();
			takeOverCountry = true;
		}
		ChalmeRisk.attack.repaintTroops(attCountry.getTroops()-1, defCountry.getTroops());	
	}
	
	//When you click "Invade" or "Retreat".
	public void endFight() {
		ChalmeRisk.attack.setVisible(false);
		if(takeOverCountry == true){
			defCountry.setOwner(attCountry.getOwner());
			attCountry.setTroops(attCountry.getTroops()-1);
			defCountry.setTroops(1);
			ChalmeRisk.movement.newMovement(attCountry, defCountry);
			ChalmeRisk.movement.setVisible(true);
		}
	}
}

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
			if(!ChalmeRisk.map.getCountry(id).getOwner().equals(ChalmeRisk.round.getCurrentPlayer())){
				ChalmeRisk.infoModel.setWarningText("You have to attack from one of your own countries!");	
			}
			else if(ChalmeRisk.map.getCountry(id).getTroops()<=1){
				ChalmeRisk.infoModel.setWarningText("You have to few troops to attack from this country!");
			}
			else{
				firstCountrySelected = true;
				attCountry = ChalmeRisk.map.getCountry(id);
				attCountry.setSelected(true);	
				ChalmeRisk.infoModel.setCorrectMoveText("You have selected the country to attack from");
			}

		}
		else {
			if(attCountry.getOwner() != ChalmeRisk.map.getCountry(id).getOwner()){
				defCountry = ChalmeRisk.map.getCountry(id);
				if (attCountry.hasNeighbour(id) == true) {
					firstCountrySelected = false;
					takeOverCountry = false;
					attCountry.setSelected(false);
					ChalmeRisk.attack.newAttack(attCountry, defCountry);
					ChalmeRisk.attack.repaintTroops(attCountry.getTroops()-1, defCountry.getTroops());
					ChalmeRisk.attack.setVisible(true);
				}
				else {
					ChalmeRisk.infoModel.setWarningText("You have to attack a neighbouring country!");
				}
			}
			else{
				ChalmeRisk.infoModel.setWarningText("You cant attack your own country!");
				attCountry.setSelected(false);
				attCountry = null;
				firstCountrySelected = false;
			}
		}	 
	}

	public void startFight() {
		int i = ChalmeRisk.dCtrl.getResult(attCountry.getTroops(), defCountry.getTroops());
		if(i==1){
			defCountry.setTroops(defCountry.getTroops() - 1);
			ChalmeRisk.attack.setStatusText("Attacker killed 1 ");
		}
		else if(i==2){
			attCountry.setTroops(attCountry.getTroops() - 1);
			ChalmeRisk.attack.setStatusText("Defender killed 1 ");
		}

		else if(i==3){
			defCountry.setTroops(defCountry.getTroops() - 2);
			ChalmeRisk.attack.setStatusText("Attacker killed 2 ");

		}
		else if(i==4){
			attCountry.setTroops(attCountry.getTroops() - 2);
			ChalmeRisk.attack.setStatusText("Defender killed 2");
		}

		else if(i==5){
			defCountry.setTroops(defCountry.getTroops() - 1);
			attCountry.setTroops(attCountry.getTroops() - 1);
			ChalmeRisk.attack.setStatusText("1 of each killed");
		}
		
		if(attCountry.getTroops() == 1){
			ChalmeRisk.attack.setDefenderWin();
		}
		
		if(defCountry.getTroops() == 0){
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
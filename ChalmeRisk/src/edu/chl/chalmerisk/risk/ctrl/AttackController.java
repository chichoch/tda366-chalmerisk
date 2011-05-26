package edu.chl.chalmerisk.risk.ctrl;

import edu.chl.chalmerisk.risk.core.ChalmeRisk;


/**
 * This class describes the Use-case Attack.
 */
public class AttackController extends TurnState{
	public static DiceController dCtrl = new DiceController();
	private boolean firstCountrySelected;

	//Constructor
	public AttackController() {
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
				ChalmeRisk.attackModel.setAttCountry(ChalmeRisk.map.getCountry(id));
				ChalmeRisk.attackModel.getAttCountry().setSelected(true);	
				ChalmeRisk.infoModel.setCorrectMoveText("You have selected the country to attack from");
			}
		}
		else {
			if(ChalmeRisk.attackModel.getAttCountry().getOwner() != ChalmeRisk.map.getCountry(id).getOwner()){
				ChalmeRisk.attackModel.setDefCountry(ChalmeRisk.map.getCountry(id));
				if (ChalmeRisk.attackModel.getAttCountry().hasNeighbour(id) == true) {
					firstCountrySelected = false;
					ChalmeRisk.attackModel.setTakeOverCountry(false);
					ChalmeRisk.attackModel.getAttCountry().setSelected(false);
					ChalmeRisk.attackModel.newAttack(ChalmeRisk.attackModel.getAttCountry(), ChalmeRisk.attackModel.getDefCountry());
				}
				else {
					ChalmeRisk.infoModel.setWarningText("You have to attack a neighbouring country!");
				}
			}
			else{
				ChalmeRisk.infoModel.setWarningText("You cant attack your own country!");
				ChalmeRisk.attackModel.getAttCountry().setSelected(false);
				ChalmeRisk.attackModel.setAttCountry(null);
				firstCountrySelected = false;
			}
		}	 
	}
	/**
	 * This class sends the number of troops to the DiceController class
	 * and gets a number between 1-5 that represent a case which determines 
	 * the outcome of the battle.
	 */

	public void startFight() {
		int i = dCtrl.getResult(ChalmeRisk.attackModel.getAttCountry().getTroops(), ChalmeRisk.attackModel.getDefCountry().getTroops());
		if(i==1){
			ChalmeRisk.attackModel.getDefCountry().setTroops(ChalmeRisk.attackModel.getDefCountry().getTroops() - 1);
			ChalmeRisk.attackModel.setStatusText("Attacker killed 1 ");
		}
		else if(i==2){
			ChalmeRisk.attackModel.getAttCountry().setTroops(ChalmeRisk.attackModel.getAttCountry().getTroops() - 1);
			ChalmeRisk.attackModel.setStatusText("Defender killed 1 ");
		}
		else if(i==3){
			ChalmeRisk.attackModel.getDefCountry().setTroops(ChalmeRisk.attackModel.getDefCountry().getTroops() - 2);
			ChalmeRisk.attackModel.setStatusText("Attacker killed 2 ");

		}
		else if(i==4){
			ChalmeRisk.attackModel.getAttCountry().setTroops(ChalmeRisk.attackModel.getAttCountry().getTroops() - 2);
			ChalmeRisk.attackModel.setStatusText("Defender killed 2");
		}
		else if(i==5){
			ChalmeRisk.attackModel.getDefCountry().setTroops(ChalmeRisk.attackModel.getDefCountry().getTroops() - 1);
			ChalmeRisk.attackModel.getAttCountry().setTroops(ChalmeRisk.attackModel.getAttCountry().getTroops() - 1);
			ChalmeRisk.attackModel.setStatusText("1 of each killed");
		}
		if(ChalmeRisk.attackModel.getAttCountry().getTroops() == 1){
			ChalmeRisk.attackModel.setDefenderWin();
		}
		if(ChalmeRisk.attackModel.getDefCountry().getTroops() == 0){
			//fight.setVisible(false);
			ChalmeRisk.attackModel.setAttackerWin();
			ChalmeRisk.attackModel.setTakeOverCountry(true);
		}
		ChalmeRisk.attackModel.callForRepaintTroops(ChalmeRisk.attackModel.getAttCountry(), ChalmeRisk.attackModel.getDefCountry());	
	}

	//When you click "Invade" or "Retreat".
	public void endFight() {
		ChalmeRisk.attackModel.endFight();
		if(ChalmeRisk.attackModel.takeOverCountry()){
			ChalmeRisk.attackModel.getDefCountry().setOwner(ChalmeRisk.attackModel.getAttCountry().getOwner());
			ChalmeRisk.attackModel.getAttCountry().setTroops(ChalmeRisk.attackModel.getAttCountry().getTroops()-1);
			ChalmeRisk.attackModel.getDefCountry().setTroops(1);
			ChalmeRisk.movementModel.newMovement(ChalmeRisk.attackModel.getAttCountry(), ChalmeRisk.attackModel.getDefCountry()); 
		}
	}
}
package edu.chl.chalmerisk.risk.core;



import edu.chl.chalmerisk.risk.ctrl.*;


public abstract class TurnState  {

	
	public void reinforcementState(ReinforcementController rCtrl){
		ChalmeRisk.infoModel.setInfoText("You are now in the Reinforcement state, place your reinforcements");
	}
	
	
	public void attackState(AttackController aCtrl){
		ChalmeRisk.infoModel.setInfoText("You are now in the Attack state");
	}
	
	public void troopMovementState(TroopMovementController tCtrl){
		ChalmeRisk.infoModel.setInfoText("You are now in the TroopMovement state");
	}
	
	public void setCountry(int n){
		//Should always be Overrided.
	}
	
	
}

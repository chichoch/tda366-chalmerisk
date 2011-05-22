package edu.chl.chalmerisk.risk.core;
import edu.chl.chalmerisk.risk.ctrl.AttackController;
import edu.chl.chalmerisk.risk.ctrl.ReinforcementController;
import edu.chl.chalmerisk.risk.ctrl.TroopMovementController;



public abstract class TurnState  {

	
	public void reinforcementState(ReinforcementController rCtrl){
	}
	
	public void attackState(AttackController aCtrl){
	}
	
	public void troopMovementState(TroopMovementController tCtrl){
	}
	
	public void setCountry(int n){
		//Should always be Overrided.
	}
	
	
}

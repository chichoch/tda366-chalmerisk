package edu.chl.chalmerisk.risk.core;

import edu.chl.chalmerisk.risk.ctrl.AttackController;
import edu.chl.chalmerisk.risk.ctrl.ReinforcementController;
import edu.chl.chalmerisk.risk.ctrl.TroopMovementController;

public abstract class TurnState {

	public void reinforcementState(ReinforcementController rCtrl){
		System.out.println("Error in reinforcement state");
	}
	
	public void attackState(AttackController aCtrl){
		System.out.println("Error in attack state");
	}
	
	public void troopMovementState(TroopMovementController tCtrl){
		System.out.println("Error in troopmovement state");
	}
	
	public void setCountry(int n){
		System.out.println("Du gick via turnstate");
	}
	
	
}

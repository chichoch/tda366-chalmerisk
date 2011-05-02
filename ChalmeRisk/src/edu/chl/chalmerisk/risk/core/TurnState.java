package edu.chl.chalmerisk.risk.core;

import edu.chl.chalmerisk.risk.ctrl.*;


public abstract class TurnState {

	public void reinforcementState(ReinforcementController rCtrl){
		//System.out.println("Finished in reinforcement state");
		Builder.guiTest.setInfo("Finished reinforcement state");
	}
	
	public void attackState(AttackController aCtrl){
		//System.out.println("Finished in attack state");
		Builder.guiTest.setInfo("Finished attack state");
	}
	
	public void troopMovementState(TroopMovementController tCtrl){
		//System.out.println("Finished in troop movement state");
		Builder.guiTest.setInfo("Finished troop movement state");
	}
	
	public void setCountry(int n){}
	
	
}

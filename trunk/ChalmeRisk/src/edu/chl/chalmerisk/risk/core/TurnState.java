package edu.chl.chalmerisk.risk.core;

import edu.chl.chalmerisk.risk.ctrl.*;


public abstract class TurnState {

	//TODO Infolabel is hardcoded, should be fixed with observers
	public void reinforcementState(ReinforcementController rCtrl){
		//System.out.println("Finished in reinforcement state");
		ChalmeRisk.guiTest.setInfo("Finished reinforcement state");
	}
	
	//TODO Infolabel is hardcoded, should be fixed with observers
	public void attackState(AttackController aCtrl){
		//System.out.println("Finished in attack state");
		ChalmeRisk.guiTest.setInfo("Finished attack state");
	}
	//TODO Infolabel is hardcoded, should be fixed with observers
	public void troopMovementState(TroopMovementController tCtrl){
		//System.out.println("Finished in troop movement state");
		ChalmeRisk.guiTest.setInfo("Finished troop movement state");
	}
	
	public void setCountry(int n){
		//Should always be Overrided.
	}
	
	
}

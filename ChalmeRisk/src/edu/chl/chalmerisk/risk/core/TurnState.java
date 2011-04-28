package edu.chl.chalmerisk.risk.core;

public abstract class TurnState {

	public void reinforcementState(Turn turn){
		System.out.print("error0");
	}
	
	public void attackState(Turn turn){
		System.out.print("errorattack");
	}
	public void troopMovementState(Turn turn){
		System.out.print("error");
	}
}

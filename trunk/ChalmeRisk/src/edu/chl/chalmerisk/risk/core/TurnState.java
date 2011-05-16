package edu.chl.chalmerisk.risk.core;



import edu.chl.chalmerisk.risk.ctrl.*;
import edu.chl.chalmerisk.risk.util.ReinforcementCalculator;


public abstract class TurnState  {

	
	public void reinforcementState(ReinforcementController rCtrl){
		//TODO Fix the bug that makes the game show the wrong text in the wrong turn, and 
		//fix the bug so that you get the right amount of reinforcement from the right turn.
		//Atm you get reinforcement from the round before.
		//ChalmeRisk.infoModel.setInfoText("You are now in the Reinforcement state, place your reinforcements");
		/*
		if(ChalmeRisk.turn.firstRoundCount()<ChalmeRisk.round.getNumberOfPlayers()*2){
			ReinforcementCalculator.getInstance().setReinforcementsFirstRounds(ChalmeRisk.round.getPlayerList());
		}
		else{
			ReinforcementCalculator.getInstance().setReinforcements(ChalmeRisk.round.getCurrentPlayer());
		}
		*/
		
	}
	
	
	public void attackState(AttackController aCtrl){
		//ChalmeRisk.infoModel.setInfoText("You are now in the Attack state");
	}
	
	public void troopMovementState(TroopMovementController tCtrl){
		//ChalmeRisk.infoModel.setInfoText("You are now in the TroopMovement state");
	}
	
	public void setCountry(int n){
		//Should always be Overrided.
	}
	
	
}

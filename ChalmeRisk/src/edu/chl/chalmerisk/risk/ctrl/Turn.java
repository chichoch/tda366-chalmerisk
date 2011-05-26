package edu.chl.chalmerisk.risk.ctrl;


import java.util.Observable;

import edu.chl.chalmerisk.risk.core.ChalmeRisk;
import edu.chl.chalmerisk.risk.core.GameOverException;


/**
 * This class is built with the State-pattern, 
 * and keeps track of which state the current player is in.
 * It also is checks if the game is in the first rounds. 
 */

public class Turn extends Observable {
	private AttackController aCtrl = new AttackController();
	private ReinforcementController rCtrl = new ReinforcementController();
	private TroopMovementController tCtrl = new TroopMovementController();
	private TurnState[] states  = {rCtrl, aCtrl, tCtrl};
	private int firstRoundsCount = 0;
	
	public void reinforcementState()  { 
		states[ChalmeRisk.turnModel.getCurrentStateIndex()].reinforcementState( rCtrl); 
	}
	   
	public void attackState() { 
		states[ChalmeRisk.turnModel.getCurrentStateIndex()].attackState( aCtrl  );  
	}
	   
	public void troopMovementState() { 
		states[ChalmeRisk.turnModel.getCurrentStateIndex()].troopMovementState( tCtrl );
		ChalmeRisk.round.newRound();
	}
	   
	public void changeState() {
		if (ChalmeRisk.turnModel.isFirstRound()){
			firstRoundState();
			if(firstRoundsCount == (ChalmeRisk.round.getNumberOfPlayers()*3)){
				ChalmeRisk.turnModel.notFirstRound();
			}
		}
		else if(ChalmeRisk.turnModel.getCurrentStateIndex() == 0){
			ChalmeRisk.turnModel.isChanged();
			reinforcementState();
			ChalmeRisk.turnModel.nextState();
		}
		else if(ChalmeRisk.turnModel.getCurrentStateIndex() == 1){
			attackState();
			ChalmeRisk.turnModel.nextState();
			try{
				ChalmeRisk.round.updatePlayers();
				if(ChalmeRisk.round.getPlayerList().size()==1){
					throw new GameOverException();
				}
			}
			catch (GameOverException e) {
				e.getClass();
			}
			finally {
				ChalmeRisk.turnModel.isChanged();
			}
		}
		else if(ChalmeRisk.turnModel.getCurrentStateIndex() == 2){
			troopMovementState();
			ChalmeRisk.turnModel.setCurrentStateIndex(0);
		}
		ChalmeRisk.turnModel.isChanged();
	}
	   
	public void currentState(){
		if(ChalmeRisk.turnModel.getCurrentStateIndex() == 0){
			reinforcementState();
		}
		else if(ChalmeRisk.turnModel.getCurrentStateIndex() == 1){
			attackState();
		}
		else{
			troopMovementState();
		}
	}
	   
	public void firstRoundState(){
		reinforcementState();
		ChalmeRisk.round.newRound();
		firstRoundsCount++;
	}
	   
	public void setCountry(int n){
		states[ChalmeRisk.turnModel.getCurrentStateIndex()].setCountry(n);
	}
}


		

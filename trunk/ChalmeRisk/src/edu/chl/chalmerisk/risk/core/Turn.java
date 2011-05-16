package edu.chl.chalmerisk.risk.core;


import java.util.List;
import java.util.Observable;

import edu.chl.chalmerisk.risk.constants.Player;
import edu.chl.chalmerisk.risk.util.ActivePlayers;
import edu.chl.chalmerisk.risk.util.ReinforcementCalculator;


public class Turn extends Observable{
	
	private TurnState[] states  = {ChalmeRisk.rCtrl, ChalmeRisk.aCtrl, ChalmeRisk.tCtrl};
	
	private int currentStateIndex = 0;
	private int firstRoundsCount = 0;
	private boolean firstRoundsIndex = true;
	
	   public void reinforcementState()  { 
		   states[currentStateIndex].reinforcementState( ChalmeRisk.rCtrl); 
	   }
	   
	   public void attackState() { 
		   states[currentStateIndex].attackState( ChalmeRisk.aCtrl  );  
	   }
	   public void troopMovementState() { 
		   states[currentStateIndex].troopMovementState( ChalmeRisk.tCtrl );
		   ChalmeRisk.round.newRound();
	   }
	   public void changeState() {
		  
		   if (firstRoundsIndex){
			  FirstRoundState();
			  if(firstRoundsCount == (ChalmeRisk.round.getNumberOfPlayers()*3)){
				  firstRoundsIndex=false;
			  }
		  }
		  else if(currentStateIndex == 0){
			  setChanged();
			  notifyObservers(0);
			  reinforcementState();
			  currentStateIndex++;
		  }
		  else if(currentStateIndex == 1){
			  	attackState();
			  	currentStateIndex++;
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
					setChanged();
					notifyObservers(0);
				}
		  }
		  else if(currentStateIndex == 2){
			  troopMovementState();
			  currentStateIndex=0;
		  }
		  setChanged();
		  notifyObservers(0);
	   }
	   public void currentState(){
		   if(currentStateIndex == 0){
			   reinforcementState();
		   }
		   else if(currentStateIndex == 1){
			   attackState();
		   }
		   else{
			   troopMovementState();
		   }
	   }
	   public void FirstRoundState(){
		   reinforcementState();
		   ChalmeRisk.round.newRound();
		   firstRoundsCount++;
	   }
	   
	  
	   public void setCountry(int n){
		   states[currentStateIndex].setCountry(n);
	   }
	   
	   public boolean isFirstRound() {
		   return firstRoundsIndex;
	   }

	   public int getCurrentStateIndex() {
		   return currentStateIndex;
	   }
}


		

package edu.chl.chalmerisk.risk.core;


import java.util.Observable;

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
			  ReinforcementCalculator.getInstance().setReinforcements(ChalmeRisk.round.getCurrentPlayer());
			  reinforcementState();
			  currentStateIndex++;
		  }
		  else if(currentStateIndex == 1){
			  attackState();
			  currentStateIndex++;
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
		   ReinforcementCalculator.getInstance().setFirstReinforcements(ChalmeRisk.round.getPlayerList());
		   reinforcementState();
		   ChalmeRisk.round.newRound();
		   firstRoundsCount++;
		   setChanged();
		   notifyObservers(1);
	   }
	   
	  
	   public void setCountry(int n){
		   states[currentStateIndex].setCountry(n);
	   }
	   
	   public Boolean isFirstRound() {
		   return firstRoundsIndex;
	   }
	   
	   public int getCurrentStateIndex() {
		   return currentStateIndex;
	   }
}


		

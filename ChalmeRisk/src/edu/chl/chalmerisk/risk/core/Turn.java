package edu.chl.chalmerisk.risk.core;


import java.util.Observable;


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
			  reinforcementState();
			  currentStateIndex++;
		  }
		  else if(currentStateIndex == 1){
			  attackState();
			  currentStateIndex++;
		  }
		  else{
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
	   
	   public Boolean isFirstRound() {
		   return firstRoundsIndex;
	   }
	   
	   public int getCurrentStateIndex() {
		   return currentStateIndex;
	   }
}


		

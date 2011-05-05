package edu.chl.chalmerisk.risk.core;



public class Turn {
	
	
	private TurnState[] states  = {ChalmeRisk.rCtrl, ChalmeRisk.aCtrl, ChalmeRisk.tCtrl};
	
	private int currentStateIndex = 0;
	
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
		   if(currentStateIndex == 0){
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
	   
	  
	   public void setCountry(int n){
		   states[currentStateIndex].setCountry(n);
	   }
	   
}


		

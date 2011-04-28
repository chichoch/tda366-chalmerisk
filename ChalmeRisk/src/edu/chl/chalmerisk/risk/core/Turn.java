package edu.chl.chalmerisk.risk.core;

import edu.chl.chalmerisk.risk.ctrl.ReinforcementController;

public class Turn {
	
	
	private TurnState[] states  = {Builder.rCtrl, Builder.aCtrl, Builder.tCtrl};
	
	private int currentStateIndex = 0;
	
	   public void reinforcementState()  { 
		   states[currentStateIndex].reinforcementState( Builder.rCtrl); 
	   }
	   
	   public void attackState() { 
		   states[currentStateIndex].attackState( Builder.aCtrl  );  
	   }
	   public void troopMovementState() { 
		   states[currentStateIndex].troopMovementState( Builder.tCtrl ); 
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


		

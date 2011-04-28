package edu.chl.chalmerisk.risk.core;

public class Turn {
	
	private int index=-1;
	private TurnState[] states  = {Builder.aCtrl};
	
	private int currentStateIndex = 0;
	
	   public void reinforcementState()  { 
		   states[currentStateIndex].reinforcementState( this ); 
	   }
	   
	   public void attackState() { 
		   states[currentStateIndex].attackState( this ); 
	   }
	   public void troopMovementState() { 
		   states[currentStateIndex].troopMovementState( this ); 
	   }
	   public void changeState() {
		   index=index+1;
		   if(index == 3){
			   index=0;
		   }
		   currentStateIndex = index; 
		   attackState();
	   }


}


		

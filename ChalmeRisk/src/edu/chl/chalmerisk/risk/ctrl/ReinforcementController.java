package edu.chl.chalmerisk.risk.ctrl;

import edu.chl.chalmerisk.risk.core.*;

public class ReinforcementController extends TurnState {

	public ReinforcementController(){
		
	}
	
	@Override
	public void setCountry(int id){
		Builder.map.getCountry(id).setTroops(Builder.map.getCountry(id).getTroops()+1);
	}
}

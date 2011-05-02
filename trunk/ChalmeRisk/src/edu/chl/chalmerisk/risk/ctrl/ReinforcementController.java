package edu.chl.chalmerisk.risk.ctrl;

import javax.swing.JOptionPane;

import edu.chl.chalmerisk.risk.core.*;

public class ReinforcementController extends TurnState {
	
	public ReinforcementController(){
		
	}
	
	@Override
	public void setCountry(int id){
		if(!Builder.map.getCountry(id).getOwner().equals(Builder.round.getCurrentPlayer())){
			JOptionPane.showMessageDialog(null, "Du kan endast sätta ut trupper i dina egna länder" );	
		}
		else{
			Builder.map.getCountry(id).setTroops(Builder.map.getCountry(id).getTroops()+1);
		}
	}
}

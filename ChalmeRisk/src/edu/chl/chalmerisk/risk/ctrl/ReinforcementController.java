package edu.chl.chalmerisk.risk.ctrl;

import javax.swing.JOptionPane;

import edu.chl.chalmerisk.risk.core.*;

public class ReinforcementController extends TurnState {
	
	public ReinforcementController(){
		
	}
	
	@Override
	public void setCountry(int id){
		if(!ChalmeRisk.map.getCountry(id).getOwner().equals(ChalmeRisk.round.getCurrentPlayer())){
			JOptionPane.showMessageDialog(null, "Du kan endast sätta ut trupper i dina egna länder" );	
		}
		else{
			ChalmeRisk.map.getCountry(id).setTroops(ChalmeRisk.map.getCountry(id).getTroops()+1);
		}
	}
}

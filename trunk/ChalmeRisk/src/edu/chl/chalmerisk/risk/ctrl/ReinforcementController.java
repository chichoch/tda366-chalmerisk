package edu.chl.chalmerisk.risk.ctrl;
import javax.swing.JOptionPane;

import edu.chl.chalmerisk.risk.core.*;

public class ReinforcementController extends TurnState {

	public ReinforcementController(){

	}

	@Override
	public void setCountry(int id){
		if(!ChalmeRisk.map.getCountry(id).getOwner().equals(ChalmeRisk.round.getCurrentPlayer())){
			ChalmeRisk.infoModel.setWarningText("You can only place reinforcements in your countries");
		}
		else if (ChalmeRisk.round.getCurrentPlayer().getReinforcements() > 0){
			ChalmeRisk.map.getCountry(id).setTroops(ChalmeRisk.map.getCountry(id).getTroops()+1);
			ChalmeRisk.round.getCurrentPlayer().decReinforcements();
		}
		else {
			ChalmeRisk.infoModel.setWarningText("You dont have anymore reinforcements");
		}
	}
}

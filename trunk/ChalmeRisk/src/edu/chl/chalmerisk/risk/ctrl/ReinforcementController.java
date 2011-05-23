package edu.chl.chalmerisk.risk.ctrl;

import edu.chl.chalmerisk.risk.core.ChalmeRisk;
import edu.chl.chalmerisk.risk.core.TurnState;

/**
 * Describes the Use-case Reinforcement.
 * @author christophe
 *
 */
public class ReinforcementController extends TurnState{

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
			ChalmeRisk.infoModel.setCorrectMoveText("You have placed one reinforcement in the selected country");
		}
		else {
			ChalmeRisk.infoModel.setWarningText("You dont have anymore reinforcements");
		}
	}
}

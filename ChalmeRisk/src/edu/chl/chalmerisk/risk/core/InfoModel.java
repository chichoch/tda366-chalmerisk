package edu.chl.chalmerisk.risk.core;

import java.util.Observable;
import java.util.Observer;
/**
 * This class is the model that the InfoView Observ.
 * Holds the information that relevant for the game.
 * Observs Turn, so it shows which turn your in.
 *
 */
public class InfoModel extends Observable implements Observer {
	private String infoText;
	private String warningText;
	private String CorrectMoveText;
	
	public InfoModel() {
		ChalmeRisk.turn.addObserver(this);
	}
	public void setInfoText(String infoText){
		this.infoText = infoText;
		setChanged();
		notifyObservers(0);
	}
	
	public void setWarningText(String warningText){
		this.warningText = warningText;
		setChanged();
		notifyObservers(1);
	}
	
	public void setCorrectMoveText(String CorrectMoveText){
		this.CorrectMoveText = CorrectMoveText;
		setChanged();
		notifyObservers(2);
	}
	
	public String getInfoText(){
		return infoText;
	}
	
	public String getWarningText(){
		return warningText;
	}
	
	public String getCorrectMoveText(){
		return CorrectMoveText;
	}

	@Override
	public void update(Observable observable, Object arg) {
		if (observable.equals(ChalmeRisk.turn)) {
			if(arg.equals(new Integer(0))){
				if (ChalmeRisk.turn.getCurrentStateIndex() == 0){
					setInfoText("You are now in the reinforcement state, place your reinforcements.");
				}
				else if (ChalmeRisk.turn.getCurrentStateIndex() == 1) {
					setInfoText("You are now in the attack state.");
				}
				else if (ChalmeRisk.turn.getCurrentStateIndex() == 2) {
					setInfoText("You are now in the troop movement state.");
				}
			}
		}
	}

}

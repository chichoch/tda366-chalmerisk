package edu.chl.chalmerisk.risk.core;

import java.util.Observable;
/**
 * This is the Model for the turn class
 * 
 */

public class TurnModel extends Observable{

	private int currentStateIndex = 0;
	private boolean isFirstRound = true;
	
	public void nextState(){
		if(currentStateIndex == 2){
			currentStateIndex = 0;
		}
		else{ 
			currentStateIndex++;
		}
	}
	
	public void setCurrentStateIndex(int i) {
		currentStateIndex = i;
	}
	
	public int getCurrentStateIndex(){
		return currentStateIndex;
	}
	
	public void notFirstRound(){
		isFirstRound = false;
		setChanged();
		notifyObservers(0);
	}
	
	public boolean isFirstRound(){
		return isFirstRound;
	}
	
	public void isChanged(){
		setChanged();
		notifyObservers(0);
	}
	
}

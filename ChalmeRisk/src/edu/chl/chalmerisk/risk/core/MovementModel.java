package edu.chl.chalmerisk.risk.core;

import java.util.Observable;

/**
 * This class notifies the MovementDialog that something has changed.
 * 
 */
public class MovementModel extends Observable {
	private Country moveFromCountry;
	private Country moveToCountry;
	private boolean allowTroopMovement;
	
	public void newMovement(Country moveFromCountry, Country moveToCountry){
		this.moveFromCountry = moveFromCountry;
		this.moveToCountry = moveToCountry;
		setChanged();
		notifyObservers(0);
	}
	
	public Country getMoveFromCountry(){
		return moveFromCountry;
	}
	
	public Country getMoveToCountry(){
		return moveToCountry;
	}
	
	public void notAllowTroopMovement (){
		allowTroopMovement=false;
	}
	
	public void allowTroopMovement(){
		allowTroopMovement=true;
	}
	
	public boolean isTroopMovementAllowed(){
		return allowTroopMovement;
	}
}

package edu.chl.chalmerisk.risk.core;

import java.util.Observable;

/**
 * A Class that describes a Dice. 
 * 
 */
public class Dice extends Observable{
	private int num;
	
	/**
	 * Constructor. Creates a dice with a random number
	 */
	public Dice() {
		tossDice();
	}
	
	 /**
	 * Returns the number the Dice have currently
	 */
	public int getNumber() {
		return num;
	} 
	/**
	 * Changes the current value of the Dice to a new random value.
	 */
	public void tossDice() {
		num = (int) ((Math.random() * 6) + 1);
		setChanged();
		notifyObservers(0);
	}
}

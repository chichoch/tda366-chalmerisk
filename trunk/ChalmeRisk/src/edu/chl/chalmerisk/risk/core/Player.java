package edu.chl.chalmerisk.risk.core;
import java.awt.Color;
import java.util.Observable;



public class Player extends Observable{
	
	private Color color;
	private String name;
	private int reinforcements = 3;
	
    public Player(Color color,String name) {
    	this.name = name;
        this.color = color;
    }
    
    public Color getColor() {
    	return color;
    }
    
    public String getName() {
    	return name;
    }
    
    public int getReinforcements(){
    	return reinforcements;
    }
    
    public void setReinforcements(int troops) {
    	this.reinforcements = troops;
    	setChanged();
    	notifyObservers(0);
    }
    /**
     * Decreases reinforcements left with 1 unit.
     */
    public void decReinforcements(){
    	reinforcements--;
    	setChanged();
    	notifyObservers(0);
    }
    
    public void setMoreReinforcements(int troops) {
    	reinforcements += troops;
    	setChanged();
    	notifyObservers(0);
    }
}

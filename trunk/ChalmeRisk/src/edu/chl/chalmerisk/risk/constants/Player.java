package edu.chl.chalmerisk.risk.constants;
import java.awt.Color;


public class Player {
	
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
    
    public void setReinforcements(int reinforcements){
    	this.reinforcements = reinforcements;
    }
}

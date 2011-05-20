package edu.chl.chalmerisk.risk.core;

import java.awt.Color;
import java.util.List;


public class Continent {
	private Player test = new Player(Color.black, "Test");
	private String name;
	private List<Country> countries;
	private int value;
	
	public Continent(String name, List<Country> c, int value){
		this.name = name;
		this.countries = c;
		this.value = value;
		
	}
	
	public String getName() {
		return name;
	}
	
	public int getValue(){
		return value;
	}
	/**
	 * 
	 * @return a list of Countries in this continent.
	 */
	public List<Country> getCountries() {
		return countries;
	}
	
	/**
	 * 
	 * @return If the continent has a owner, it returns that player. If it doesn't have a owner 
	 * it returns null.
	 *
	 */
	public Player getOwner() {
		Player p = countries.get(0).getOwner();
		for (int i = 1; i < countries.size(); i++) {
			if (!countries.get(i).getOwner().equals(p)) {
				return test;
			}
		}
		return p;
	}
}

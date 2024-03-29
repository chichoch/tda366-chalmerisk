package edu.chl.chalmerisk.risk.core;

import java.util.Observable;

/**
 * This class describes a Country. 
 * The Country is one of the main-elements of the game, so we have
 * collected lots of information here.
 *
 */

public class Country extends Observable{
	private int troops;
	private String country;
	private int countryid;
	private Player owner;
	private String continent;
	private int[] neighbours;
	//The "x" and "y" is coordinates for the country.
	private int x;
	private int y;
	private boolean isSelected;
	
	public Country() {
		
	}

	public Country(String s, int id, int x, int y, int t, int[] n, Player owner) {
		this.country = s;
		this.countryid = id;
		this.x = x;
		this.y = y;
		this.troops = t;
		this.neighbours = n;
		this.owner = owner;
		setChanged();
		notifyObservers(0);
		notifyObservers(1);
	}
	
	public String getName() {
		return country;
	}
	
	public int getTroops() {
		return troops;
	}

	public Player getOwner() {
		return owner;
	}
	public int getCountryId(){
		return countryid;
	}
	
	public void setTroops(int i) {
		troops = i;
		setChanged();
		notifyObservers(0);
	}
	
	public void setOwner(Player p) {
		owner = p;
		setChanged();
		notifyObservers(1);
	}
	
	/**
	 * Check if the CountryId is a Neighbour to this Country.
	 * @param countryId
	 * @return Boolean
	 */
	public boolean hasNeighbour(int countryId){
		for ( int i = 0; i < neighbours.length; i++  ){
			if ( neighbours[i] == countryId){
			return true;	
			}
		}
		return false;
	}
	
	public String getContinent() {
		return continent;
	}
	
	public void setContinent(String e) {
		continent = e;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setSelected(boolean isSelected){
		this.isSelected = isSelected;
		setChanged();
		notifyObservers(2);
	}
	public boolean isSelected(){
		return isSelected;
	}
}
package edu.chl.chalmerisk.risk.constants;

import java.util.Observable;


public class Country extends Observable{
	private int troops;
	private String country;
	private int countryid;
	private Player owner;
	private String continent;
	private int[] grannar;
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
		this.grannar = n;
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
	
	public boolean hasNeighbour(int n){
		for ( int i = 0; i < grannar.length; i++  ){
			if ( grannar[i] == n){
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
	//TODO Remove?
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	//TODO Remove?
	public void setY(int y) {
		this.y = y;
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
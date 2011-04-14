package edu.chl.chalmerisk.risk.constants;

import java.util.List;
import java.util.Observable;

import edu.chl.chalmerisk.risk.*;


public class Country extends Observable{
	private int troops;
	private String country;
	private int countryid;
	private Player owner;
	private String continent;

	private int[] grannar;

	public Country() {
		
	}
	/*
	public Country(String s, int id, int t) {
		this.country = s;
		this.countryid = id;
		this.troops = t;
	}
	*/

	
	public Country(String s, int id, int t, int[] n, Player owner) {
		this.country = s;
		this.countryid = id;
		this.troops = t;
		this.grannar = n;
		this.owner = owner;
	}
	

	public Country(String country, Player owner, int troops){
		this.country = country;
		this.owner = owner;
		this.troops = troops;
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
		notifyObservers(0);
	}
	
	public void setOwner(Player p) {
		owner = p;
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
}

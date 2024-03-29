package edu.chl.chalmerisk.risk.core;

import java.util.Observable;
/**
 * AttackModel, Notifies the View, when changes have been done in the controller.
 *
 */
public class AttackModel extends Observable {
	private Country attCountry;
	private Country defCountry;
	private String statusText;
	private boolean takeOverCountry = false;
	
	public void newAttack(Country attCountry, Country defCountry){
		this.attCountry = attCountry;
		this.defCountry = defCountry;
		setChanged();
		notifyObservers(0);
	}
	
	public void setStatusText(String statusText){
		this.statusText = statusText;
		setChanged();
		notifyObservers(1);
	}
	
	public void setAttackerWin(){
		setChanged();
		notifyObservers(2);
	}
	
	public void setDefenderWin(){
		setChanged();
		notifyObservers(3);
	}
	
	public void setAttCountry(Country attCountry){
		this.attCountry = attCountry;
	}
	
	public void setDefCountry(Country defCountry){
		this.defCountry = defCountry;
	}
	
	public void setTakeOverCountry(boolean takeOverCountry){
		this.takeOverCountry = takeOverCountry;
	}
	
	public void callForRepaintTroops(Country attCountry, Country defCountry){
		this.attCountry = attCountry;
		this.defCountry = defCountry;
		setChanged();
		notifyObservers(4);
	}
	
	public void endFight(){
		setChanged();
		notifyObservers(5);
	}
	
	public Country getAttCountry(){
		return attCountry;
	}
	
	public Country getDefCountry(){
		return defCountry;
	}
	public String getStatusText(){
		return statusText;
	}
	
	public boolean takeOverCountry(){
		return takeOverCountry;
	}
}

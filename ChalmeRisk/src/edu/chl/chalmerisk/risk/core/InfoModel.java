package edu.chl.chalmerisk.risk.core;

import java.util.Observable;

public class InfoModel extends Observable{
	private String infoText;
	private String warningText;
	
	public void setInfoText(String infoText){
		this.infoText = infoText;
		setChanged();
		notifyObservers(0);
	}
	
	public void setWarningText(String warningText){
		this.warningText = warningText;
		setChanged();
		notifyObservers(1);
	}
	
	public String getInfoText(){
		return infoText;
	}
	
	public String getWarningText(){
		return warningText;
	}

}

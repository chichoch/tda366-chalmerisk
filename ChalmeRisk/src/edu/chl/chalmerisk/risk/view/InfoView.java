package edu.chl.chalmerisk.risk.view;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import edu.chl.chalmerisk.risk.core.ChalmeRisk;
import edu.chl.chalmerisk.risk.core.InfoModel;

public class InfoView extends JLabel implements Observer {
	
	public InfoView (){
		setText("Welcome to ChalmeRisk!");
		ChalmeRisk.infoModel.addObserver(this);
	}
	
	@Override
	public void update(Observable observable, Object arg) {		
		if(observable.equals(ChalmeRisk.infoModel)){
			if(arg.equals(new Integer(0))){
				setText(ChalmeRisk.infoModel.getInfoText());
				setForeground(Color.WHITE);
			}
			if(arg.equals(new Integer(1))){
				setText(ChalmeRisk.infoModel.getWarningText());
				setForeground(Color.RED);
			}
		}
	}
}

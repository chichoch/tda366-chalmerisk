package edu.chl.chalmerisk.risk.view;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import edu.chl.chalmerisk.risk.core.ChalmeRisk;

/**
 * The view for the infolabel 
 *
 */

public class InfoView extends JLabel implements Observer {
	
	public InfoView (){
		setForeground(Color.WHITE);
		setText("Welcome to ChalmeRisk! "+" You are now in the reinforcement state, place your reinforcements.");
		ChalmeRisk.infoModel.addObserver(this);
	}
	
	@Override
	public void update(Observable observable, Object arg) {		
		if(observable.equals(ChalmeRisk.infoModel)){
			if(arg.equals(Integer.valueOf(0))){
				setText(ChalmeRisk.infoModel.getInfoText());
				setForeground(Color.WHITE);
			}
			if(arg.equals(Integer.valueOf(1))){
				setText(ChalmeRisk.infoModel.getWarningText());
				setForeground(Color.RED);
			}
			if(arg.equals(Integer.valueOf(2))){
				setText(ChalmeRisk.infoModel.getCorrectMoveText());
				setForeground(Color.GREEN);
			}
		}
	}
}

package edu.chl.chalmerisk.risk.view;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Icon;
import javax.swing.JLabel;

import edu.chl.chalmerisk.risk.core.ChalmeRisk;

public class SequenceMap extends JLabel implements Observer {
	private Icon imageIcon;
	public SequenceMap() {
		ChalmeRisk.turn.addObserver(this);
	}
	@Override
	public void update(Observable observable, Object arg) {
		// TODO Auto-generated method stub
		if(observable.equals(ChalmeRisk.turn)){
			if(arg.equals(new Integer(0))) {
				setText("" + ChalmeRisk.turn.getCurrentStateIndex());
			}
			if(arg.equals(new Integer(1))) {
				
			}
		}
		setIcon(imageIcon);
		
	}
	
	
}
package edu.chl.chalmerisk.risk.view;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import edu.chl.chalmerisk.risk.core.ChalmeRisk;

public class SequenceMap extends JLabel implements Observer {
	private ImageIcon imageIcon;
	private int state;
	private String player;
	
	public SequenceMap() {
		imageIcon = new ImageIcon("resources/SQr1.gif");
		setIcon(imageIcon);
		ChalmeRisk.turn.addObserver(this);
		ChalmeRisk.round.addObserver(this);
		setPreferredSize(new Dimension(160,40));
		setOpaque(false);
		setVisible(true);
	}
	@Override
	public void update(Observable observable, Object arg) {
		// TODO Auto-generated method stub
		if(observable.equals(ChalmeRisk.turn)){
			if(arg.equals(new Integer(0))) {
				state = ChalmeRisk.turn.getCurrentStateIndex() + 1;
			}
		}
		if(observable.equals(ChalmeRisk.round)) {
			if(arg.equals(new Integer(0))) {
				if (ChalmeRisk.round.getCurrentPlayer().getColor().equals(Color.RED))
					player = "r";
				else if(ChalmeRisk.round.getCurrentPlayer().getColor().equals(Color.blue))
					player = "b";
				else if(ChalmeRisk.round.getCurrentPlayer().getColor().equals(Color.yellow))
					player = "y";
				else if(ChalmeRisk.round.getCurrentPlayer().getColor().equals(Color.green))
					player = "g";
			}
			
		}
		imageIcon = new ImageIcon("resources/SQ" + player + state + ".gif");
		setIcon(imageIcon);
		
	}
}
package edu.chl.chalmerisk.risk.view;

import java.awt.*;
import java.util.*;

import javax.swing.*;

import edu.chl.chalmerisk.risk.constants.Player;
import edu.chl.chalmerisk.risk.core.ChalmeRisk;
import edu.chl.chalmerisk.risk.core.Round;


public class PlayerView extends JLabel implements Observer{
	
	public PlayerView(){
		ChalmeRisk.round.addObserver(this);
		
		setPreferredSize(new Dimension(200,30));
		setText("  "+ChalmeRisk.round.getCurrentPlayer().getName()+"`s turn");
		setFont(new Font("Courier New", Font.BOLD, 18));
		setForeground(Color.RED);
		setVisible(true);
		
	}
	@Override
	public void update(Observable observable, Object arg) {
		if(observable.equals(ChalmeRisk.round)){
			if(arg.equals(new Integer(0))){
				setText("  "+ChalmeRisk.round.getCurrentPlayer().getName()+"`s turn");
				setForeground(ChalmeRisk.round.getCurrentPlayer().getColor());
				
			}
		}
	}
}

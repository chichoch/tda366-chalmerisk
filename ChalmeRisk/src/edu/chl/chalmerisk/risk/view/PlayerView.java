package edu.chl.chalmerisk.risk.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

import edu.chl.chalmerisk.risk.core.ChalmeRisk;


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
			if(arg.equals(Integer.valueOf(0))){
				setText("  "+ChalmeRisk.round.getCurrentPlayer().getName()+"`s turn");
				setForeground(ChalmeRisk.round.getCurrentPlayer().getColor());
				
			}
		}
	}
}

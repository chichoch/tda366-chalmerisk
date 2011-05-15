package edu.chl.chalmerisk.risk.core;

import javax.swing.JOptionPane;

public class GameOverException extends Exception {
	public GameOverException() {
		JOptionPane.showMessageDialog(null, "Spelet är slut! Vinnaren är: " + ChalmeRisk.round.getCurrentPlayer().getName());
		System.exit(0);
	}
		
}

package edu.chl.chalmerisk.risk.core;

import javax.swing.JOptionPane;

public class GameOverException extends Exception {
	public GameOverException() {
		JOptionPane.showMessageDialog(null, "The game is over! The winner is: " + ChalmeRisk.round.getCurrentPlayer().getName());
		System.exit(0);
	}
		
}

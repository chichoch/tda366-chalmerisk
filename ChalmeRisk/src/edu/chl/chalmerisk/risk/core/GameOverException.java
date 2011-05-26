package edu.chl.chalmerisk.risk.core;

import javax.swing.JOptionPane;

/**
 * GameOverException. 
 * Shows the winner.
 * 
 */
public class GameOverException extends RuntimeException {
	public GameOverException() {
		JOptionPane.showMessageDialog(null, "The game is over! The winner is: " + ChalmeRisk.round.getCurrentPlayer().getName());
	}
}

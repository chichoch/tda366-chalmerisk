package edu.chl.chalmerisk.risk.core;

import javax.swing.JOptionPane;

import edu.chl.chalmerisk.risk.view.MenuView;
import edu.chl.chalmerisk.risk.view.ViewBuilder;

/**
 * GameOverException. 
 * Shows the winner and close the application.
 * 
 */
public class GameOverException extends RuntimeException {
	public GameOverException() {
		JOptionPane.showMessageDialog(null, "The game is over! The winner is: " + ChalmeRisk.round.getCurrentPlayer().getName());
	}
}

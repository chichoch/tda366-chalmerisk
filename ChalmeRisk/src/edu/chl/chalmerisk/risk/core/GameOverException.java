package edu.chl.chalmerisk.risk.core;

import javax.swing.JOptionPane;

public class GameOverException extends Exception {
	public GameOverException() {
		JOptionPane.showMessageDialog(null, "Spelet är slut!");
	}
		
}

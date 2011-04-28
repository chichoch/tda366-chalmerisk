package edu.chl.chalmerisk.risk.view;

import java.awt.*;
import javax.swing.*;

public class MovementDialog extends JFrame {
	
	private JPanel movementPanel;
	private JLabel firstCountry;
	private JButton increase;
	private JButton decrease;
	private JButton movePlayers;
	private JLabel secondCountry;
	
	public MovementDialog(){
		firstCountry = new JLabel("First");
		increase = new JButton("+");
		decrease = new JButton("-");
		movePlayers = new JButton("Move Players!");
		secondCountry = new JLabel("Second");
		movementPanel = new JPanel();
		
		movementPanel.setLayout(new GridLayout(3,1));
		movementPanel.add(increase);
		movementPanel.add(decrease);
		movementPanel.add(movePlayers);
		
		add(firstCountry, BorderLayout.WEST);
		add(secondCountry, BorderLayout.EAST);
		add(movementPanel, BorderLayout.CENTER);
		
		setUndecorated(true);
		setVisible(false);
		pack();
		setSize(300,300);
	}
	public void newMovement(){
		setVisible(true);
	}
}

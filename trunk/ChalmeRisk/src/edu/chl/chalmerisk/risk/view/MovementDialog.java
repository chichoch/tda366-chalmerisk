package edu.chl.chalmerisk.risk.view;

import java.awt.*;
import javax.swing.*;

public class MovementDialog extends JFrame {
	
	private JPanel movementPanel;
	private JSlider quantity;
	private JButton moveTroops;
	
	public MovementDialog(){
		quantity = new JSlider();
		quantity.setMajorTickSpacing(10);
		quantity.setPaintLabels(true);
		moveTroops = new JButton("Move troops!");
		movementPanel = new JPanel();
		
		movementPanel.setLayout(new GridLayout(2,1));
		movementPanel.add(quantity);
		movementPanel.add(moveTroops);
		
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

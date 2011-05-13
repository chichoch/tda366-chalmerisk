package edu.chl.chalmerisk.risk.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import edu.chl.chalmerisk.risk.constants.Country;
import edu.chl.chalmerisk.risk.core.ChalmeRisk;

public class MovementDialog extends JFrame implements ActionListener {
	
	private JPanel movementPanelCenter;
	private JPanel movementPanelSouth;
	private JSlider quantitySlider;
	private JButton moveTroopsButton;
	private JButton cancelButton;
	// Variables to store two countries
	private Country c1;
	private Country c2;
	
	
	public MovementDialog(){
		quantitySlider = new JSlider();
		quantitySlider.setMinimum(1);
		quantitySlider.setMajorTickSpacing(1);
		quantitySlider.setSnapToTicks(true);
		moveTroopsButton = new JButton("Move troops!");
		cancelButton = new JButton("Cancel");
		movementPanelCenter = new JPanel();
		movementPanelSouth = new JPanel();
		
		movementPanelCenter.setLayout(new GridLayout(1,1));
		movementPanelCenter.add(quantitySlider);
		movementPanelSouth.setLayout(new GridLayout(2,1));
		movementPanelSouth.add(moveTroopsButton);
		movementPanelSouth.add(cancelButton);
		
		add(movementPanelCenter, BorderLayout.CENTER);
		add(movementPanelSouth, BorderLayout.SOUTH);
		
		setUndecorated(true);
		setVisible(false);
		pack();
		setLocation(500, 200);
		setSize(300,150);
	
		

		
		moveTroopsButton.addActionListener(this); 
		cancelButton.addActionListener(this);
		
	}
		public void actionPerformed(ActionEvent e){
			
			if(e.getSource() == moveTroopsButton){
				ChalmeRisk.tCtrl.doMovement(quantitySlider.getValue(), c1, c2);
				setVisible(false);
				if(ChalmeRisk.turn.getCurrentStateIndex()==2){
					ChalmeRisk.tCtrl.notAllowTroopMovement();
				}
				
			}
			
			if(e.getSource()== cancelButton){
				setVisible(false);
			}
	}

	public void newMovement(Country fromCountry, Country toCountry){
		moveTroopsButton.setEnabled(true);
		cancelButton.setEnabled(true);
		quantitySlider.setMaximum(fromCountry.getTroops()-1);
		quantitySlider.setValue(1);
		quantitySlider.setPaintLabels(true);
		c1=fromCountry;
		c2=toCountry;
	}
}

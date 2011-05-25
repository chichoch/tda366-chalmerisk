package edu.chl.chalmerisk.risk.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import edu.chl.chalmerisk.risk.core.ChalmeRisk;
import edu.chl.chalmerisk.risk.core.Country;
import edu.chl.chalmerisk.risk.ctrl.TroopMovementController;

public class MovementDialog extends JFrame implements ActionListener, Observer {
	
	private JPanel movementPanelCenter;
	private JPanel movementPanelSouth;
	private JSlider quantitySlider;
	private JButton moveTroopsButton;
	private JButton cancelButton;
	// Variables to store two countries
	private Country c1;
	private Country c2;
	
	
	public MovementDialog(){
		ChalmeRisk.movementModel.addObserver(this);
		quantitySlider = new JSlider();
		quantitySlider.setMinimum(1);
		//Hashtable for the labels in the JSlider
		Hashtable<Integer, JLabel> table = new Hashtable<Integer, JLabel>();
		table.put(1,new JLabel("1"));
		table.put(2,new JLabel("2"));
		table.put(3,new JLabel("3"));
		table.put(4,new JLabel("4"));
		table.put(5,new JLabel("5"));
		table.put(6,new JLabel("6"));
		table.put(7,new JLabel("7"));
		table.put(8,new JLabel("8"));
		table.put(9,new JLabel("9"));
		table.put(10,new JLabel("10"));
		table.put(15,new JLabel("15"));
		table.put(20,new JLabel("20"));
		table.put(25,new JLabel("25"));
		table.put(30,new JLabel("30"));
		table.put(35,new JLabel("35"));
		table.put(40,new JLabel("40"));
		table.put(45,new JLabel("45"));
		table.put(50,new JLabel("50"));
		table.put(55,new JLabel("55"));
		table.put(60,new JLabel("60"));
		quantitySlider.setMinorTickSpacing(1);
		quantitySlider.setLabelTable(table);
		quantitySlider.setPaintTicks(true);
		quantitySlider.setSnapToTicks(true);
		moveTroopsButton = new JButton("Move troops!");
		cancelButton = new JButton("Dont Move Troops / Cancel");
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
				new TroopMovementController().doMovement(quantitySlider.getValue(), c1, c2);
				setVisible(false);
				if(ChalmeRisk.turnModel.getCurrentStateIndex()==2){
					ChalmeRisk.movementModel.notAllowTroopMovement();
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
	@Override
	public void update(Observable observable, Object arg) {
		if(observable.equals(ChalmeRisk.movementModel)){
			if(arg.equals(new Integer(0))){
				newMovement(ChalmeRisk.movementModel.getMoveFromCountry(), ChalmeRisk.movementModel.getMoveToCountry());
				setVisible(true);
			}
		}
	}
}

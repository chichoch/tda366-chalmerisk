package edu.chl.chalmerisk.risk.view;

import java.awt.Color;
import edu.chl.chalmerisk.risk.*;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

import edu.chl.chalmerisk.risk.constants.Country;
import edu.chl.chalmerisk.risk.core.Builder;

public class AttackDialog extends JFrame{
	private JPanel attTeamPanel;
	private JPanel defTeamPanel;
	private JPanel actionPanel;
	private JLabel status;
	private JLabel standings;
	private ImageIcon attCannon;
	private ImageIcon attHorse;
	private ImageIcon attInfantry;
	private ImageIcon defCannon;
	private ImageIcon defHorse;
	private ImageIcon defInfantry;
	private JButton fight;
	private JButton retreat;
	
	public AttackDialog() {
		status = new JLabel();
		attTeamPanel = new JPanel();
		defTeamPanel = new JPanel();
		actionPanel = new JPanel();
		fight = new JButton("Fight!");
		retreat = new JButton("Retreat!");
		standings = new JLabel();
		
		setPanel(attTeamPanel);
		setPanel(defTeamPanel);
		setPanel(actionPanel);
		
		actionPanel.add(status);
		actionPanel.add(fight);
		actionPanel.add(retreat);
		actionPanel.add(standings);
		
		attCannon = new ImageIcon("resources/greenCannon.gif");
		attHorse = new ImageIcon("resources/KnightSmall.gif");
		attInfantry = new ImageIcon("resources/greenInfantry.gif");
		defCannon = new ImageIcon("resources/redCannon.gif");
		defHorse = new ImageIcon("resources/KnightRed.gif");
		defInfantry = new ImageIcon("resources/redInfantry.gif");
		
		//repaintTroops(att.getTroops(), def.getTroops());
		
		setLayout(new GridLayout(1,3));
		setUndecorated(true);
		setVisible(false);
		pack();
		setLocation(450, 200);
		setSize(400, 400);
		
		add(attTeamPanel);
		add(actionPanel);
		add(defTeamPanel);
		
		//actionlisteners
		fight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				Builder.aCtrl.startFight();
			}
		});
		
		retreat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				Builder.aCtrl.endFight();
			}
		});
	}
	
	//constructor thats sets up the window
	public AttackDialog(Country att, Country def){
		status = new JLabel();
		attTeamPanel = new JPanel();
		defTeamPanel = new JPanel();
		actionPanel = new JPanel();
		fight = new JButton("Fight!");
		retreat = new JButton("Retreat!");
		standings = new JLabel();
		
		setPanel(attTeamPanel);
		setPanel(defTeamPanel);
		setPanel(actionPanel);
		
		actionPanel.add(status);
		actionPanel.add(fight);
		actionPanel.add(retreat);
		actionPanel.add(standings);
		
		attCannon = (Builder.iconHandler.getIcon(att.getOwner(), 10));
		attHorse = (Builder.iconHandler.getIcon(att.getOwner(), 5));
		attInfantry = (Builder.iconHandler.getIcon(att.getOwner(), 1));
		defCannon = (Builder.iconHandler.getIcon(def.getOwner(), 10));
		defHorse = (Builder.iconHandler.getIcon(att.getOwner(), 5));
		defInfantry = (Builder.iconHandler.getIcon(att.getOwner(), 1));
		
		//repaintTroops(att.getTroops(), def.getTroops());
		
		setLayout(new GridLayout(1,3));
		setUndecorated(true);
		setVisible(false);
		pack();
		setLocation(450, 200);
		setSize(400, 400);
		
		add(attTeamPanel);
		add(actionPanel);
		add(defTeamPanel);
		
		//actionlisteners
		fight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				Builder.aCtrl.startFight();
			}
		});
		
		retreat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				Builder.aCtrl.endFight();
			}
		});
	}
	
	public void setPanel(JPanel panel){
		panel.setVisible(true);
		panel.setLayout(new GridLayout(4,1));
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	//Paints up troops in the panels
	public void repaintTroops(int attTroops, int defTroops){
		attTeamPanel.removeAll();
		defTeamPanel.removeAll();
		while(attTroops>0 ){
			if(attTroops%10==0){
				attTroops=attTroops-10;
				attTeamPanel.add(new JLabel(attCannon));
			}
			else if(attTroops%5==0){
				attTroops=attTroops-5;
				attTeamPanel.add(new JLabel(attHorse));
			}
			else{
				attTroops=attTroops-1;
				attTeamPanel.add(new JLabel(attInfantry));
			}
		}
		while(defTroops>0 ){
			if(defTroops%10==0){
				defTroops=defTroops-10;
				defTeamPanel.add(new JLabel(defCannon));
			}
			else if(defTroops%5==0){
				defTroops=defTroops-5;
				defTeamPanel.add(new JLabel(defHorse));
			}
			else{
				defTroops=defTroops-1;
				defTeamPanel.add(new JLabel(defInfantry));
			}
		}
		repaint();
		validate();
	}
	
	public void setStatusText(String s) {
		status.setText(s);
	}
	
	public void setAttackerWin() {
		fight.setEnabled(false);
		retreat.setText("Invade!");
	}
	
	public void setDefenderWin() {
		fight.setEnabled(false);
		retreat.setText("Flee");
	}
	
	public void newAttack() {
		fight.setEnabled(true);
		retreat.setText("Retreat");
		status.setText("");
	}
}

	


package edu.chl.chalmerisk.risk.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

import edu.chl.chalmerisk.risk.core.ChalmeRisk;
import edu.chl.chalmerisk.risk.core.Country;

public class AttackDialog extends JFrame{
	private JPanel fightPanel;
	private JPanel attTeamPanel;
	private JPanel defTeamPanel;
	private JPanel actionPanel;
	private JLabel statusLabel;
	private JLabel standingsLabel;
	private ImageIcon attCannon;
	private ImageIcon attHorse;
	private ImageIcon attInfantry;
	private ImageIcon defCannon;
	private ImageIcon defHorse;
	private ImageIcon defInfantry;
	private JButton fightButton;
	private JButton retreatButton;
	private JPanel dicePanel;
	private JPanel fillPanel;
	private DiceView a1dice;
	private DiceView a2dice;
	private DiceView a3dice;
	private DiceView d1dice;
	private DiceView d2dice;
	
	//TODO Bug! (I think?) IN the label, if the defending country only have 1 troop left
	// The label can say that the defender have killed 2.
	public AttackDialog() {
		fightPanel = new JPanel(new GridLayout(1,3));
		statusLabel = new JLabel();
		attTeamPanel = new JPanel();
		defTeamPanel = new JPanel();
		actionPanel = new JPanel();
		fightButton = new JButton("Fight!");
		retreatButton = new JButton("Retreat!");
		standingsLabel = new JLabel();
		dicePanel = new JPanel();
		a1dice = new DiceView(ChalmeRisk.dCtrl.getAttDice1());
		a2dice = new DiceView(ChalmeRisk.dCtrl.getAttDice2());
		a3dice = new DiceView(ChalmeRisk.dCtrl.getAttDice3());
		d1dice = new DiceView(ChalmeRisk.dCtrl.getDefDice1());
		d2dice = new DiceView(ChalmeRisk.dCtrl.getDefDice2());
		fillPanel = new JPanel();
		
		setPanel(attTeamPanel);
		setPanel(defTeamPanel);
		setPanel(actionPanel);
		setPanel(dicePanel);
		
		actionPanel.add(statusLabel);
		actionPanel.add(fightButton);
		actionPanel.add(retreatButton);
		actionPanel.add(standingsLabel);
		
		dicePanel.setLayout(new GridLayout(1,6));
		dicePanel.add(a1dice);
		dicePanel.add(a2dice);
		dicePanel.add(a3dice);
		dicePanel.add(fillPanel);
		dicePanel.add(d1dice);
		dicePanel.add(d2dice);
		
		//repaintTroops(att.getTroops(), def.getTroops());
		
		//setLayout();
		setUndecorated(true);
		setVisible(false);
		pack();
		setLocation(450, 200);
		setSize(400, 400);
		
		fightPanel.add(attTeamPanel);
		fightPanel.add(actionPanel);
		fightPanel.add(defTeamPanel);
		add(fightPanel, BorderLayout.CENTER);
		add(dicePanel, BorderLayout.SOUTH);
		
		//actionlisteners
		fightButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				ChalmeRisk.aCtrl.startFight();
			}
		});
		
		retreatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				ChalmeRisk.aCtrl.endFight();
			}
		});
	}
	
	//constructor thats sets up the window
	public AttackDialog(Country att, Country def){
		statusLabel = new JLabel();
		attTeamPanel = new JPanel();
		defTeamPanel = new JPanel();
		actionPanel = new JPanel();
		fightButton = new JButton("Fight!");
		retreatButton = new JButton("Retreat!");
		standingsLabel = new JLabel();
		dicePanel = new JPanel();
		a1dice = new DiceView(ChalmeRisk.dCtrl.getAttDice1());
		a2dice = new DiceView(ChalmeRisk.dCtrl.getAttDice2());
		a3dice = new DiceView(ChalmeRisk.dCtrl.getAttDice3());
		d1dice = new DiceView(ChalmeRisk.dCtrl.getDefDice1());
		d2dice = new DiceView(ChalmeRisk.dCtrl.getDefDice2());
		fillPanel = new JPanel();
		
		dicePanel.setLayout(new GridLayout(1,6));
		dicePanel.add(a1dice);
		dicePanel.add(a2dice);
		dicePanel.add(a3dice);
		dicePanel.add(fillPanel);
		dicePanel.add(d1dice);
		dicePanel.add(d2dice);
		
		setPanel(attTeamPanel);
		setPanel(defTeamPanel);
		setPanel(actionPanel);
		setPanel(dicePanel);
		
		actionPanel.add(statusLabel);
		actionPanel.add(fightButton);
		actionPanel.add(retreatButton);
		actionPanel.add(standingsLabel);
		
		attCannon = (ViewBuilder.iconHandler.getIcon(att.getOwner(), 10));
		attHorse = (ViewBuilder.iconHandler.getIcon(att.getOwner(), 5));
		attInfantry = (ViewBuilder.iconHandler.getIcon(att.getOwner(), 1));
		defCannon = (ViewBuilder.iconHandler.getIcon(def.getOwner(), 10));
		defHorse = (ViewBuilder.iconHandler.getIcon(att.getOwner(), 5));
		defInfantry = (ViewBuilder.iconHandler.getIcon(att.getOwner(), 1));
		
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
		add(dicePanel);
		
		//actionlisteners
		fightButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				ChalmeRisk.aCtrl.startFight();
			}
		});
		
		retreatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				ChalmeRisk.aCtrl.endFight();
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
		statusLabel.setText(s);
	}
	
	public void setAttackerWin() {
		fightButton.setEnabled(false);
		retreatButton.setText("Invade!");
	}
	
	public void setDefenderWin() {
		fightButton.setEnabled(false);
		retreatButton.setText("Flee");
	}
	
	public void newAttack(Country att, Country def) {
		fightButton.setEnabled(true);
		a1dice.newDice();
		a2dice.newDice();
		a3dice.newDice();
		d1dice.newDice();
		d2dice.newDice();
		retreatButton.setText("Retreat");
		statusLabel.setText("");
		attCannon = (ViewBuilder.iconHandler.getIcon(att.getOwner(), 10));
		attHorse = (ViewBuilder.iconHandler.getIcon(att.getOwner(), 5));
		attInfantry = (ViewBuilder.iconHandler.getIcon(att.getOwner(), 1));
		defCannon = (ViewBuilder.iconHandler.getIcon(def.getOwner(), 10));
		defHorse = (ViewBuilder.iconHandler.getIcon(def.getOwner(), 5));
		defInfantry = (ViewBuilder.iconHandler.getIcon(def.getOwner(), 1));
	}
}

	


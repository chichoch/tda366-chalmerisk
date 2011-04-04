import java.awt.Color;
import java.awt.event.*;
import java.awt.*;

import javax.swing.*;


public class Attack extends JFrame {
	private JPanel attTeamPanel;
	private JPanel defTeamPanel;
	private JPanel actionPanel;
	private JLabel status;
	private ImageIcon attCannon;
	private ImageIcon attHorse;
	private ImageIcon attInfantry;
	private ImageIcon defCannon;
	private ImageIcon defHorse;
	private ImageIcon defInfantry;
	private JButton fight;
	private int attTroops;
	private int defTroops;
	private JButton retreat;
	private JLabel standings;
	
	public Attack(final Country att, final Country def){
		status = new JLabel();
		attTeamPanel = new JPanel();
		defTeamPanel = new JPanel();
		actionPanel = new JPanel();
		fight = new JButton("Fight!");
		attTroops = att.getTroops();
		defTroops = def.getTroops();
		retreat = new JButton("Retreat!");
		standings = new JLabel();
		
		fight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				fight(att, def);
				setTroops(attTroops, defTroops);
			}
		});
		
		retreat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				att.setTroops(attTroops);
				def.setTroops(defTroops);
				System.exit(0);
			}
		});
		
		setPanel(attTeamPanel);
		setPanel(defTeamPanel);
		setPanel(actionPanel);
		
		actionPanel.add(status);
		actionPanel.add(fight);
		actionPanel.add(retreat);
		actionPanel.add(standings);
		
		attCannon = new ImageIcon("greenCannon.gif");
		attHorse = new ImageIcon("KnightSmall.gif");
		attInfantry = new ImageIcon("greenInfantry.gif");
		defCannon = new ImageIcon("redCannon.gif");
		defHorse = new ImageIcon("KnightRed.gif");
		defInfantry = new ImageIcon("redInfantry.gif");
		
		setTroops(att.getTroops(), def.getTroops());
		
		setLayout(new GridLayout(1,3));
		setUndecorated(true);
		setVisible(true);
		pack();
		setLocation(450, 200);
		setSize(400, 400);
		
		add(attTeamPanel);
		add(actionPanel);
		add(defTeamPanel);
	}
	
	public void setPanel(JPanel panel){
		panel.setVisible(true);
		panel.setLayout(new GridLayout(4,1));
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	public void setTroops(int attTroops, int defTroops){
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
	public void fight(Country att, Country def){
		double i = Math.random()*10;
		if(i < 5){
			attTroops = attTroops-1;
			status.setText("Red killed 1");
		}
		else if(i>=5){
			defTroops = defTroops -1;
			status.setText("Green Killed 1");
		}
		if(attTroops == 1){
			//fight.setVisible(false);
			fight.setEnabled(false);
			retreat.setText("Flee");
		}
		if(defTroops == 0){
			//fight.setVisible(false);
			fight.setEnabled(false);
			retreat.setText("Invade!");
			def.setOwner(att.getOwner());
		}
	}
}


package edu.chl.chalmerisk.risk.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.Color;
import java.io.FileNotFoundException;

import javax.swing.*;


import edu.chl.chalmerisk.risk.Main;
import edu.chl.chalmerisk.risk.core.ChalmeRisk;

public class MenuView extends JFrame implements ActionListener, ItemListener{
	private JPanel leftPanel;
	private JPanel rightPanel;
	private JPanel centerPanel;
	private JButton startGameButton;
	private JButton tutorialButton;
	private JButton exitGameButton;
	private JButton startPlayingButton;
	private JButton back;
	private JLabel whatMap;
	private JLabel numberOfPlayersLabel;
	private JLabel playerName1;
	private JLabel playerName2;
	private JLabel playerName3;
	private JLabel playerName4;
	private JTextField playerTextField1;
	private JTextField playerTextField2;
	private JTextField playerTextField3;
	private JTextField playerTextField4;
	private JComboBox map;
	private Choice numberOfPlayers;
	final static String main = "mainCard";
	final static String option = "optionCard";
	
	
	public MenuView (){
		// Setting up the buttons for the Maincard
		startGameButton = new JButton("Start game");
		startGameButton.setPreferredSize(new Dimension(260, 106));
		startGameButton.addActionListener(this);
		
		tutorialButton = new JButton("Tutorial");
		tutorialButton.setPreferredSize(new Dimension(260, 106));
		tutorialButton.addActionListener(this);
		
		exitGameButton  = new JButton("Exit game");
		exitGameButton.setPreferredSize(new Dimension(260, 106));
		exitGameButton.addActionListener(this);
		
		// Setting up the option items
		whatMap = new JLabel("What map do you want to play?");
		numberOfPlayersLabel = new JLabel("How many players?");
		numberOfPlayersLabel.setPreferredSize(new Dimension (180, 30));
		numberOfPlayers = new Choice();
		numberOfPlayers.add("2");
		numberOfPlayers.add("3");
		numberOfPlayers.add("4");
		numberOfPlayers.addItemListener(this);
		playerName1 = new JLabel("Name of player one:");
		playerName1.setForeground(Color.RED);
		playerName2 = new JLabel("Name of player two:");
		playerName2.setForeground(Color.GREEN);
		playerName3 = new JLabel("Name of player three:");
		playerName3.setForeground(Color.YELLOW);
		playerName4 = new JLabel("Name of PLayer four");
		playerName4.setForeground(Color.BLUE);
		playerTextField1 = new JTextField();
		playerTextField1.setPreferredSize(new Dimension (240, 30));
		playerTextField2 = new JTextField();
		playerTextField2.setPreferredSize(new Dimension (240, 30));
		playerTextField3 = new JTextField();
		playerTextField3.setEnabled(false);
		playerTextField3.setPreferredSize(new Dimension (240, 30));
		playerTextField4 = new JTextField();
		playerTextField4.setEnabled(false);
		playerTextField4.setPreferredSize(new Dimension (240, 30));
		startPlayingButton = new JButton("Start");
		startPlayingButton.setPreferredSize(new Dimension(120, 45));
		startPlayingButton.addActionListener(this);
		String maps[] = { "testmap", "Ingen karta" };
		map = new JComboBox(maps);
		map.setPreferredSize(new Dimension (240, 30));
		back = new JButton("Back");
		back.setPreferredSize(new Dimension(120, 45));
		back.addActionListener(this);
		
		// Setting up the left panel
		leftPanel = new JPanel();
		leftPanel.setBackground(Color.BLACK);
		leftPanel.setPreferredSize(new Dimension(500, 535));
		
		//Setting up the right panel
		rightPanel = new JPanel();
		rightPanel.setBackground(Color.BLACK);
		rightPanel.setPreferredSize(new Dimension(500, 535));
		
		// Main menu card
		JPanel mainCard = new JPanel();
		mainCard.setLayout(new FlowLayout());
		mainCard.add(startGameButton);
		mainCard.add(tutorialButton);
		mainCard.add(exitGameButton);
		
        // Option menu card
		JPanel optionCard = new JPanel();
		optionCard.setLayout(new FlowLayout());
		optionCard.add(numberOfPlayersLabel);
		optionCard.add(numberOfPlayers);
		optionCard.add(playerName1);
		optionCard.add(playerTextField1);
		optionCard.add(playerName2);
		optionCard.add(playerTextField2);
		optionCard.add(playerName3);
		optionCard.add(playerTextField3);
		optionCard.add(playerName4);
		optionCard.add(playerTextField4);
		optionCard.add(whatMap);
		optionCard.add(map);
		optionCard.add(back);
		optionCard.add(startPlayingButton);
	
		// Setting up the center Cardpanel
		centerPanel = new JPanel(new CardLayout());
		centerPanel.add(mainCard, main);
		centerPanel.add(optionCard, option);
		add(leftPanel, BorderLayout.WEST);
	    add(centerPanel, BorderLayout.CENTER);
	    add(rightPanel, BorderLayout.EAST);
	    
	    //setting for the mainframe
	    setUndecorated(true);
	    setLocation(300, 120);
	    setMinimumSize(new Dimension(780, 530));
	    setPreferredSize(new Dimension(780,530));
	    pack();
	    setVisible(true);
	    setExtendedState(getExtendedState()|Frame.MAXIMIZED_BOTH);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startGameButton) {
			CardLayout cl = (CardLayout)(centerPanel.getLayout());
	        cl.show(centerPanel, option);
		}
		if (e.getSource() == tutorialButton) {
	
		}
		if (e.getSource() == exitGameButton) {
			System.exit(0);
		}
		if (e.getSource() == back) {
			CardLayout cl = (CardLayout)(centerPanel.getLayout());
	        cl.show(centerPanel, main);
		}
		if (e.getSource() == startPlayingButton) {
			if(playerTextField2.getText().isEmpty() == true && playerTextField3.getText().isEmpty() == true && playerTextField3.getText().isEmpty() == true){
				JOptionPane.showMessageDialog(null, "Atleast Player one and Player two has to be active!");
			}
			else{
				try {
					Main.mCtrl.newGame(playerTextField1.getText(), playerTextField2.getText(), playerTextField3.getText(), playerTextField4.getText(), (String)map.getSelectedItem());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
			}
		}
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		if(numberOfPlayers.getSelectedIndex()==0){
			playerTextField1.setEnabled(true);
			playerTextField2.setEnabled(true);
			playerTextField3.setEnabled(false);
			playerTextField4.setEnabled(false);
		}
		if(numberOfPlayers.getSelectedIndex()==1){
			playerTextField1.setEnabled(true);
			playerTextField2.setEnabled(true);
			playerTextField3.setEnabled(true);
			playerTextField4.setEnabled(false);
		}
		if(numberOfPlayers.getSelectedIndex()==2){
			playerTextField1.setEnabled(true);
			playerTextField2.setEnabled(true);
			playerTextField3.setEnabled(true);
			playerTextField4.setEnabled(true);
		}
	} 
	
}

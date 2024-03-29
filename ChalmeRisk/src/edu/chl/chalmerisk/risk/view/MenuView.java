package edu.chl.chalmerisk.risk.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import edu.chl.chalmerisk.risk.core.ChalmeRisk;
import edu.chl.chalmerisk.risk.core.Player;

/**
 * The menu
 *
 */
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
	private JLabel horseLabel;
	private JLabel infLabel;
	private JLabel headingLabel;
	
	
	public MenuView (){
		// Setting up the buttons for the Maincard
		ImageIcon heading = new ImageIcon("resources/ChalmeRiskHeading.gif");
		headingLabel = new JLabel(heading);
		
		ImageIcon startgame = new ImageIcon("resources/startGame.gif");
		startGameButton = new JButton(startgame);
		startGameButton.setPreferredSize(new Dimension(260, 106));
		startGameButton.addActionListener(this);
		
		ImageIcon tutorial = new ImageIcon("resources/tutorial.gif");
		tutorialButton = new JButton(tutorial);
		tutorialButton.setPreferredSize(new Dimension(260, 106));
		tutorialButton.addActionListener(this);
		
		ImageIcon exitgame = new ImageIcon("resources/exitGame.gif");
		exitGameButton  = new JButton(exitgame);
		exitGameButton.setPreferredSize(new Dimension(260, 106));
		exitGameButton.addActionListener(this);
		
		// Setting up the option items
		whatMap = new JLabel("What map do you want to play?");
		whatMap.setForeground(Color.WHITE);
		numberOfPlayersLabel = new JLabel("How many players?");
		numberOfPlayersLabel.setForeground(Color.WHITE);
		numberOfPlayersLabel.setPreferredSize(new Dimension (180, 30));
		numberOfPlayers = new Choice();
		numberOfPlayers.setBackground(Color.WHITE);
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
		playerName4 = new JLabel("Name of player four:");
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
		ImageIcon start = new ImageIcon("resources/startButton.gif");
		startPlayingButton = new JButton(start);
		startPlayingButton.setPreferredSize(new Dimension(120, 45));
		startPlayingButton.addActionListener(this);
		
		//add your maps here (the name should be the same as the name of the file.
		//for example: testmap.txt would be testmap
		String maps[] = { "testmap", "Ingen karta" };
		
		map = new JComboBox(maps);
		map.setPreferredSize(new Dimension (240, 30));
		ImageIcon backImage = new ImageIcon("resources/backButton.gif");
		back = new JButton(backImage);
		back.setPreferredSize(new Dimension(120, 45));
		back.addActionListener(this);
		
		// Setting up the left panel
		ImageIcon horse = new ImageIcon("resources/startHorse.jpg");
		horseLabel = new JLabel(horse);
		leftPanel = new JPanel();
		leftPanel.setBackground(Color.BLACK);
		leftPanel.add(horseLabel);
		leftPanel.setPreferredSize(new Dimension(500, 535));
		
		//Setting up the right panel
		ImageIcon inf = new ImageIcon("resources/startInf.jpg");
		infLabel = new JLabel(inf);
		rightPanel = new JPanel();
		rightPanel.add(infLabel);
		rightPanel.setBackground(Color.BLACK);
		rightPanel.setPreferredSize(new Dimension(500, 535));
		
		// Main menu card
		JPanel mainCard = new JPanel();
		mainCard.setBackground(Color.BLACK);
		mainCard.setLayout(new FlowLayout());
		mainCard.add(headingLabel);
		mainCard.add(startGameButton);
		mainCard.add(tutorialButton);
		mainCard.add(exitGameButton);
		
        // Option menu card
		JPanel optionCard = new JPanel();
		optionCard.setBackground(Color.BLACK);
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
	
	public void startGame(String player1, String player2, String player3, String player4, String map) throws FileNotFoundException{
		List<Player> pList = new ArrayList<Player>();
		if(player1.isEmpty()==false){
			Player PlayerOne = new Player(Color.RED, player1);
			pList.add(PlayerOne);
		}
		if(player2.isEmpty()==false){
			Player PlayerTwo = new Player(Color.GREEN, player2);
			pList.add(PlayerTwo);
		}
		if(player3.isEmpty()==false){
			Player PlayerThree = new Player(Color.YELLOW, player3);
			pList.add(PlayerThree);
		}
		if(player4.isEmpty()==false){
			Player PlayerFour = new Player(Color.BLUE, player4);
			pList.add(PlayerFour);
		}
		new ChalmeRisk(pList, map);
		new ViewBuilder();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startGameButton) {
			CardLayout cl = (CardLayout)(centerPanel.getLayout());
	        cl.show(centerPanel, option);
		}
		if (e.getSource() == tutorialButton) {
			new TutorialView();
		}
		if (e.getSource() == exitGameButton) {
			processEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		
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
					startGame(playerTextField1.getText(), playerTextField2.getText(), playerTextField3.getText(), playerTextField4.getText(), (String)map.getSelectedItem());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				setVisible(false);
			}
		}
	}
	//Checks how many players thats selected and enables/disables textfields
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

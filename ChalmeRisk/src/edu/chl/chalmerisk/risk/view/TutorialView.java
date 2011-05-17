package edu.chl.chalmerisk.risk.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class TutorialView extends JFrame implements ActionListener {
	
	private JButton backButton1;
	private JPanel backPanel1;
	private JPanel backPanel2;
	private JButton backButton2;
	private JScrollPane scrollPane;
	private JPanel mainWindowPanel;
	private JLabel tutorialheadingLabel;
	private JLabel tutorial1Label;
	private JLabel tutorial2Label;
	private JLabel tutorial3Label;
	private JLabel tutorial4Label;
	private JLabel tutorialspace1Label;
	private JLabel tutorialspace2Label;
	private JLabel tutorialspace3Label;

	public TutorialView(){
		
		mainWindowPanel = new JPanel();
		mainWindowPanel.setLayout(new BoxLayout(mainWindowPanel, BoxLayout.PAGE_AXIS));
		backPanel1 = new JPanel(new GridLayout(1,1));
		backButton1 = new JButton("Back");
		backButton1.addActionListener(this);
		backPanel1.setPreferredSize(new Dimension(200,80));
		backPanel1.add(backButton1);
		backPanel2 = new JPanel(new GridLayout(1,1));
		backButton2 = new JButton("Back");
		backButton2.addActionListener(this);
		backPanel2.setPreferredSize(new Dimension(200,80));
		backPanel2.add(backButton2);
	
		ImageIcon tutorialheading = new ImageIcon("resources/tutorialheading.gif");
		ImageIcon tutorial1 = new ImageIcon("resources/tutorial1.gif");
		ImageIcon tutorialspace = new ImageIcon("resources/tutorialspace.gif");
		ImageIcon tutorial2 = new ImageIcon("resources/tutorial2.gif");
		ImageIcon tutorial3 = new ImageIcon("resources/tutorial3.gif");
		ImageIcon tutorial4 = new ImageIcon("resources/tutorial4.gif");
		
		tutorialheadingLabel = new JLabel(tutorialheading);
		tutorial1Label = new JLabel(tutorial1);
		tutorial2Label = new JLabel(tutorial2);
		tutorial3Label = new JLabel(tutorial3);
		tutorial4Label = new JLabel(tutorial4);
		tutorialspace1Label = new JLabel(tutorialspace);
		tutorialspace2Label = new JLabel(tutorialspace);
		tutorialspace3Label = new JLabel(tutorialspace);
		
		//mainWindowPanel.setBackground(Color.BLACK);
		backPanel1.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainWindowPanel.add(backPanel1);
		tutorialheadingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainWindowPanel.add(tutorialheadingLabel);
		tutorial1Label.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainWindowPanel.add(tutorial1Label);
		tutorialspace1Label.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainWindowPanel.add(tutorialspace1Label);
		tutorial2Label.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainWindowPanel.add(tutorial2Label);
		tutorialspace2Label.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainWindowPanel.add(tutorialspace2Label);
		tutorial3Label.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainWindowPanel.add(tutorial3Label);
		tutorialspace3Label.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainWindowPanel.add(tutorialspace3Label);
		tutorial4Label.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainWindowPanel.add(tutorial4Label);
		backPanel2.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainWindowPanel.add(backPanel2);
		mainWindowPanel.setVisible(true);
		
		scrollPane = new JScrollPane(mainWindowPanel);
		scrollPane.setVisible(true);
		
		add(scrollPane);
		setUndecorated(true);
		setExtendedState(getExtendedState()|Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== backButton1 || e.getSource()==backButton2){
			setVisible(false);
		}
		
	}

}

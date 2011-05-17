package edu.chl.chalmerisk.risk.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class TutorialView extends JFrame implements ActionListener {
	
	private JButton backButton1;
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
		
	
		
	
		ImageIcon tutorialheading = new ImageIcon("resources/tutorialheading.gif");
		ImageIcon tutorial1 = new ImageIcon("resources/tutorial1.gif");
		ImageIcon tutorialspace = new ImageIcon("resources/tutorialspace.gif");
		ImageIcon tutorial2 = new ImageIcon("resources/tutorial2.gif");
		ImageIcon tutorial3 = new ImageIcon("resources/tutorial3.gif");
		ImageIcon tutorial4 = new ImageIcon("resources/tutorial4.gif");
		ImageIcon back = new ImageIcon("resources/backBig.gif");
		
		tutorialheadingLabel = new JLabel(tutorialheading);
		tutorial1Label = new JLabel(tutorial1);
		tutorial2Label = new JLabel(tutorial2);
		tutorial3Label = new JLabel(tutorial3);
		tutorial4Label = new JLabel(tutorial4);
		tutorialspace1Label = new JLabel(tutorialspace);
		tutorialspace2Label = new JLabel(tutorialspace);
		tutorialspace3Label = new JLabel(tutorialspace);
		backButton1 = new JButton(back);
		backButton1.setBackground(Color.WHITE);
		backButton1.addActionListener(this);
		backButton2 = new JButton(back);
		backButton2.setBackground(Color.WHITE);
		backButton2.addActionListener(this);
		
		
		
		backButton1.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainWindowPanel.add(backButton1);
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
		backButton2.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainWindowPanel.add(backButton2);
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

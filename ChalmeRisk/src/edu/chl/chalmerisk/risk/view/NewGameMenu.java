package edu.chl.chalmerisk.risk.view;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import edu.chl.chalmerisk.risk.core.*;


public class NewGameMenu extends JPanel implements ActionListener{
	
	private JButton startGameButton;
	private JPanel sliderPanel;
	private JLabel numPlayerLabel;
	private JSlider numPlayerSlider;
	private JButton optionsButton;
	private JButton aboutButton;
	private JButton exitGameButton;
	private FlowLayout layout; 
	
			  
		
	public NewGameMenu(){
		    
		startGameButton = new JButton();
		sliderPanel = new JPanel();
		numPlayerSlider = new JSlider();
		numPlayerLabel = new JLabel("Ange antal spelare:");
		optionsButton = new JButton();
		aboutButton = new JButton();
		exitGameButton = new JButton();
		layout =  new FlowLayout();

		startGameButton.setText("Start Game"); 
		startGameButton.setPreferredSize(new Dimension(260, 106));

		numPlayerSlider.setMinimum(2);
		numPlayerSlider.setMaximum(4);
		numPlayerSlider.setMajorTickSpacing(1);
		numPlayerSlider.setSnapToTicks(true);
		numPlayerSlider.setPaintLabels(true);
		
		
		sliderPanel.setPreferredSize(new Dimension(260, 106));
		sliderPanel.add(numPlayerLabel);
		sliderPanel.add(numPlayerSlider);
		

		optionsButton.setText("Options"); 
		optionsButton.setPreferredSize(new Dimension(260, 106));
		

		aboutButton.setText("About"); 
		aboutButton.setPreferredSize(new Dimension(260, 106));
	

		exitGameButton.setText("Exit Game"); 
		exitGameButton.setPreferredSize(new Dimension(260, 106));
		
		
		add(startGameButton);
		add(sliderPanel);
		add(optionsButton);
		add(aboutButton);
		add(exitGameButton);
		
		setPreferredSize(new Dimension(260, 535));
		setLayout(layout);
        layout.setVgap(0);
		setVisible(true);

		        
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==startGameButton){
		}
		
	}
}

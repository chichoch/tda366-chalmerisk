package edu.chl.chalmerisk.risk.view;


import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import edu.chl.chalmerisk.risk.core.ChalmeRisk;


public class StartMenu extends JFrame implements ActionListener{
		private JButton newGameButton;
	    private JButton tutorialButton;
	    private JButton optionsButton;
	    private JButton aboutButton;
	    private JButton exitGameButton;
	    private JPanel buttonPanel;
	    private FlowLayout layout; 
	    private JPanel rightPanel;
	    private JPanel leftPanel;
	  
	
	    public StartMenu(){
	    
	        leftPanel = new JPanel();
	        buttonPanel = new JPanel();
	        rightPanel = new JPanel();
	        newGameButton = new JButton();
	        tutorialButton = new JButton();
	        optionsButton = new JButton();
	        aboutButton = new JButton();
	        exitGameButton = new JButton();
	        layout =  new FlowLayout();
	       
	        
	
	        leftPanel.setBackground(Color.BLACK); 
	        leftPanel.setPreferredSize(new Dimension(260, 535));


	        buttonPanel.setPreferredSize(new Dimension(260, 535));
	        layout.setVgap(0);
	        buttonPanel.setLayout(layout);
	        

	        newGameButton.setText("New Game"); 
	        newGameButton.setPreferredSize(new Dimension(260, 106));
	        buttonPanel.add(newGameButton);

	        tutorialButton.setText("Tutorial"); 
	        tutorialButton.setPreferredSize(new Dimension(260, 106));
	        buttonPanel.add(tutorialButton);

	        optionsButton.setText("Options"); 
	        optionsButton.setPreferredSize(new Dimension(260, 106));
	        buttonPanel.add(optionsButton);

	        aboutButton.setText("About"); 
	        aboutButton.setPreferredSize(new Dimension(260, 106));
	        buttonPanel.add(aboutButton);

	        exitGameButton.setText("Exit Game"); 
	        exitGameButton.setPreferredSize(new Dimension(260, 106));
	        buttonPanel.add(exitGameButton);


	        rightPanel.setBackground(Color.BLACK); 
	        rightPanel.setPreferredSize(new Dimension(260, 535));


	       add(leftPanel, BorderLayout.WEST);
	       add(buttonPanel, BorderLayout.CENTER);
	       add(rightPanel, BorderLayout.EAST);
	       setUndecorated(true);
	       setLocation(300, 120);
	       setMinimumSize(new Dimension(780, 530));
	       setPreferredSize(new Dimension(780,530));
	       pack();
	       setVisible(true);

	        
	    
	       //ActionListeners
	       newGameButton.addActionListener(new ActionListener() {
	    	   public void actionPerformed(ActionEvent e) {
	    		   if(e.getSource()==newGameButton){
	    			   setVisible(false);
	    		   }
		
	    	   }
	       });
	       exitGameButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					System.exit(0);
				}
			});
	    }


		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
}



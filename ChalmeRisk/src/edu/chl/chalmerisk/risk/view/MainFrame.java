package edu.chl.chalmerisk.risk.view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import edu.chl.chalmerisk.risk.core.ChalmeRisk;


public class MainFrame extends JFrame implements MouseListener, ActionListener {
	private JLayeredPane karta;
	private JPanel bottom;
	private JPanel top;
	private JPanel norge;
	private JPanel denmark;
	private JPanel sweden;
	private JPanel finland;
	private JButton nextStep;
	private JLabel infoLabel;
	
	//TODO No hardcode here!
	public MainFrame() {
		setLayout(new BorderLayout());
		ImageIcon icon = new ImageIcon("resources/testmap1.jpg");
		
		karta = new JLayeredPane();
		karta.setBackground(Color.BLUE);
		
		//Set icons
		JLabel l = new JLabel(icon);
		norge = new CountryView(ChalmeRisk.map.getCountry(1)); 
		sweden = new CountryView(ChalmeRisk.map.getCountry(2)); 
		finland = new CountryView(ChalmeRisk.map.getCountry(3)); 
		denmark = new CountryView(ChalmeRisk.map.getCountry(4)); 
	
		//Set bounds
		norge.setBounds(600, 235, 60, 75);
		norge.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
		sweden.setBounds(780, 310, 60, 75);
		sweden.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
		denmark.setBounds(880, 270, 60, 75);
		denmark.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
		finland.setBounds(630, 310, 60, 75);
		finland.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        karta.add(norge, JLayeredPane.DEFAULT_LAYER);
        karta.add(sweden, JLayeredPane.DEFAULT_LAYER);
        karta.add(denmark, JLayeredPane.DEFAULT_LAYER);
        karta.add(finland, JLayeredPane.DEFAULT_LAYER);
        
        //Add MouseListeners
        norge.addMouseListener(this);
        sweden.addMouseListener(this);
        denmark.addMouseListener(this);
        finland.addMouseListener(this);

        l.setIcon(icon); // NOI18N
        l.setBounds(0, -50, 1400, 800);
        karta.add(l, JLayeredPane.DEFAULT_LAYER);
	
		bottom = new JPanel();
		nextStep = new JButton("Nästa steg");
		nextStep.addActionListener(this);
		infoLabel= new JLabel("Info");
		bottom.add(infoLabel);
		bottom.add(nextStep);
		top = new JPanel();
		top.setBackground(Color.BLACK);
		
		
		
		setTitle("ChalmeRisk");
		add(karta, BorderLayout.CENTER);
		add(bottom, BorderLayout.SOUTH);
		add(top, BorderLayout.NORTH);
		
		setExtendedState(getExtendedState()|Frame.MAXIMIZED_BOTH); //Fullscreen
		setVisible(true);
		pack();
	}
	
	public void setInfo(String info){
		infoLabel.setText(info);
	}
	
	

	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == norge) {
			ChalmeRisk.turn.setCountry(1);
		}
		if (e.getSource() == sweden) {
			ChalmeRisk.turn.setCountry(2);
		}
		if (e.getSource() == finland) {
			ChalmeRisk.turn.setCountry(3);
		}
		if (e.getSource() == denmark) {
			ChalmeRisk.turn.setCountry(4);
		}
	}

	


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== nextStep){
			ChalmeRisk.turn.changeState();
		}
		
	}
}

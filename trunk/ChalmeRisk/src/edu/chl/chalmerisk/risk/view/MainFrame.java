package edu.chl.chalmerisk.risk.view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.*;

import edu.chl.chalmerisk.risk.constants.Country;
import edu.chl.chalmerisk.risk.core.ChalmeRisk;


public class MainFrame extends JFrame implements MouseListener, ActionListener {
	private JLayeredPane karta;
	private JPanel bottom;
	private JPanel top;
	private CountryView cv;
	private JButton nextStep;
	private JLabel infoLabel;
	private PlayerView pv;
	private SequenceMap sm;
	private JPanel emptySpace;
	
	//TODO No hardcode here!
	public MainFrame(List<Country> list) {
		setLayout(new BorderLayout());
		ImageIcon icon = new ImageIcon(ChalmeRisk.map.getIconFileName());
		
		karta = new JLayeredPane();
		karta.setBackground(Color.BLACK);
		
		//Set icons
		JLabel l = new JLabel(icon);
		for (int i = 0; i < list.size(); i++) {
			cv = new CountryView(list.get(i));
			cv.setBounds(list.get(i).getX(), list.get(i).getY(), 60, 75);
			cv.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
			karta.add(cv, JLayeredPane.DEFAULT_LAYER);
			cv.addMouseListener(this);
		}
		
        l.setIcon(icon); // NOI18N
        l.setBounds(-18, -80, 1400, 800);
        karta.add(l, JLayeredPane.DEFAULT_LAYER);
	
		bottom = new JPanel();
		nextStep = new JButton("Nästa steg");
		nextStep.addActionListener(this);
		infoLabel= new JLabel("Info");
		bottom.add(infoLabel);
		bottom.add(nextStep);
		bottom.setBackground(Color.BLACK);
		top = new JPanel(new GridLayout(1,3));
		pv= new PlayerView();
		sm = new SequenceMap();
		//emptySpace = new JPanel();
		//emptySpace.setBackground(Color.BLACK);
		//emptySpace.setSize(new Dimension(300, 40));
		top.add(pv);
		top.add(sm);
		top.setPreferredSize(new Dimension (1400,40));
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
		//infoLabel.setText(info);
	}
	
	

	
	@Override
	public void mouseClicked(MouseEvent e) {
		ChalmeRisk.turn.setCountry(((CountryView) e.getSource()).getCountry().getCountryId());
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

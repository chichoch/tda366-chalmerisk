package edu.chl.chalmerisk.risk.view;


import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import edu.chl.chalmerisk.risk.constants.Country;
import edu.chl.chalmerisk.risk.core.ChalmeRisk;


public class MainFrame extends JFrame implements MouseListener, ActionListener, MouseMotionListener, Observer {
	private JLayeredPane karta;
	private JPanel bottom;
	private JPanel top;
	private JPanel infoViewPanel;
	private CountryView cv;
	private JButton nextStep;
	private PlayerView pv;
	private SequenceMap sm;
	private InfoView infoView;
	private ReinforcementPanel reinforcementPanel;
	
	//TODO No hardcode here!
	public MainFrame(List<Country> list) {
		setLayout(new BorderLayout());
		ImageIcon icon = new ImageIcon(ChalmeRisk.map.getIconFileName());
		reinforcementPanel = new ReinforcementPanel(ChalmeRisk.round.getCurrentPlayer().getReinforcements());
		addMouseMotionListener(this);
		reinforcementPanel.addMouseMotionListener(this);

		reinforcementPanel.setBounds(140, 140, 30, 75);
		reinforcementPanel.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
		karta = new JLayeredPane();
		karta.setBackground(Color.BLACK);
		karta.add(reinforcementPanel, JLayeredPane.DEFAULT_LAYER);
		//Set icons
		JLabel l = new JLabel(icon);
		for (int i = 0; i < list.size(); i++) {
			cv = new CountryView(list.get(i));
			cv.setBounds(list.get(i).getX(), list.get(i).getY(), 60, 75);
			cv.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
			karta.add(cv, JLayeredPane.DEFAULT_LAYER);
			cv.addMouseListener(this);
			cv.addMouseMotionListener(this);
		}
		
        l.setIcon(icon); // NOI18N
        l.setBounds(-18, -80, 1400, 800);
        karta.add(l, JLayeredPane.DEFAULT_LAYER);
        
        
		bottom = new JPanel();
		nextStep = new JButton("Next step");
		nextStep.addActionListener(this);
		for (int i = 0; i < ChalmeRisk.round.getPlayerList().size(); i++){
			ChalmeRisk.round.getPlayerList().get(i).addObserver(this);
		}
		nextStep.setEnabled(false);
		infoView = new InfoView();
		
		infoViewPanel = new JPanel();
		infoViewPanel.setBackground(Color.BLACK);
		infoViewPanel.setMaximumSize(new Dimension(1200,25));
		infoViewPanel.setMinimumSize(new Dimension(1200,25));
		infoViewPanel.setPreferredSize(new Dimension(1200,25));
		infoViewPanel.add(infoView);
	
		bottom.add(infoViewPanel);
		bottom.add(nextStep);
		bottom.setBackground(Color.BLACK);
		
		top = new JPanel(new GridLayout(1,3));
		pv= new PlayerView();
		sm = new SequenceMap();
		
		top.add(pv);
		top.add(sm);
		top.setPreferredSize(new Dimension (1400,40));
		top.setBackground(Color.BLACK);
	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("ChalmeRisk");
		add(karta, BorderLayout.CENTER);
		add(bottom, BorderLayout.SOUTH);
		add(top, BorderLayout.NORTH);
		
		setExtendedState(getExtendedState()|Frame.MAXIMIZED_BOTH); //Fullscreen
		setVisible(true);
		pack();
	}
	
	/*//TODO no hardcode here
	public void setInfo(String info){
		infoLabel.setForeground(Color.WHITE);
		infoLabel.setText(info);

		//infoLabel.setText(info);

	}*/
	
	

	
	@Override
	public void mouseClicked(MouseEvent e) {
		ChalmeRisk.turn.setCountry(((CountryView) e.getSource()).getCountry().getCountryId());
	}

	


	@Override
	public void mouseEntered(MouseEvent arg0) {
		
		
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
			if (ChalmeRisk.turn.getCurrentStateIndex() == 0) {
				nextStep.setEnabled(false);
				ChalmeRisk.tCtrl.allowTroopMovement();
			}
		}
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	//TODO Maybe not the best way to check if we should show the reinforcementPanel?
	@Override
	public void mouseMoved(MouseEvent arg0) {
		if (ChalmeRisk.turn.getCurrentStateIndex() == 0) {
			reinforcementPanel.setVisible(true);
			reinforcementPanel.setLocation((int)getMousePosition().getX() , (int)getMousePosition().getY() - 50);
			validate();
		}
		else {
			reinforcementPanel.setVisible(false);
		}
	}

	@Override
	public void update(Observable observable, Object arg) {
		if(observable.equals(ChalmeRisk.round.getCurrentPlayer())){
			if(arg.equals(new Integer(0))){
				if(ChalmeRisk.round.getCurrentPlayer().getReinforcements()==0){
					nextStep.setEnabled(true);	
					//validate();
				}
			}
		}
	}
}

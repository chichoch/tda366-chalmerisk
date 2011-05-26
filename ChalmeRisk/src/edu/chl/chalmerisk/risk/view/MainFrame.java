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
import java.awt.event.MouseMotionListener;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import edu.chl.chalmerisk.risk.core.ChalmeRisk;
import edu.chl.chalmerisk.risk.core.Country;
import edu.chl.chalmerisk.risk.ctrl.Turn;


public class MainFrame extends JFrame implements MouseListener, ActionListener, MouseMotionListener, Observer {
	private JLayeredPane karta;
	private JPanel bottom;
	private JPanel top;
	private JPanel infoViewPanel;
	private JPanel fillPanel;
	private JPanel fillPanel1;
	private CountryView cv;
	private JButton nextStep;
	private PlayerView pv;
	private SequenceMap sm;
	private InfoView infoView;
	private ReinforcementPanel reinforcementPanel;
	private GridLayout layout;
	public static Turn turn = new Turn();
	
	public MainFrame(List<Country> list) {
		setLayout(new BorderLayout());
		setBackground(Color.BLACK);
		addMouseMotionListener(this);
		ImageIcon icon = new ImageIcon(ChalmeRisk.map.getIconFileName());
		
		reinforcementPanel = new ReinforcementPanel(ChalmeRisk.round.getCurrentPlayer().getReinforcements());
		reinforcementPanel.addMouseMotionListener(this);
		reinforcementPanel.setBounds(140, 140, 30, 75);
		reinforcementPanel.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
		
		karta = new JLayeredPane();
		karta.setBackground(Color.BLACK);
		karta.add(reinforcementPanel, JLayeredPane.DEFAULT_LAYER);
		//Set icons
		JLabel map = new JLabel(icon);
		for (int i = 0; i < list.size(); i++) {
			cv = new CountryView(list.get(i));
			cv.setBounds(list.get(i).getX(), list.get(i).getY(), 60, 75);
			cv.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
			karta.add(cv, JLayeredPane.DEFAULT_LAYER);
			cv.addMouseListener(this);
			cv.addMouseMotionListener(this);
		}
		
        map.setIcon(icon); 
        map.setBounds(-18, -72, 1400, 800);
        map.setBackground(Color.BLACK);
        karta.add(map, JLayeredPane.DEFAULT_LAYER);
        
		bottom = new JPanel();
		bottom.setBackground(Color.BLACK);
		nextStep = new JButton("Next step");
		nextStep.addActionListener(this);
		for (int i = 0; i < ChalmeRisk.round.getPlayerList().size(); i++){
			ChalmeRisk.round.getPlayerList().get(i).addObserver(this);
		}
		nextStep.setEnabled(false);
		
		infoView = new InfoView();
		infoViewPanel = new JPanel();
		
		fillPanel = new JPanel();
		infoViewPanel.setBackground(Color.BLACK);
		infoViewPanel.setMaximumSize(new Dimension(1200,25));
		infoViewPanel.setMinimumSize(new Dimension(1200,25));
		infoViewPanel.setPreferredSize(new Dimension(1200,25));
		fillPanel.setBackground(Color.BLACK);
		fillPanel.setPreferredSize(new Dimension(100,5));
		infoViewPanel.add(fillPanel);
		infoViewPanel.add(infoView);
		
	
		bottom.add(infoViewPanel);
		bottom.add(nextStep);
		bottom.setBackground(Color.BLACK);
		
		layout = new GridLayout(1,3);
		layout.setHgap(430);
		top = new JPanel(layout);
		fillPanel1 = new JPanel();
		fillPanel1.setBackground(Color.BLACK);
		pv= new PlayerView();
		sm = new SequenceMap();
		
		top.add(pv);
		top.add(sm);
		top.add(fillPanel1);
		
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
		
	@Override
	public void mouseClicked(MouseEvent e) {
		turn.setCountry(((CountryView) e.getSource()).getCountry().getCountryId());
	}

	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		//Do nothing
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		//Do nothing
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		//Do nothing
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		//Do nothing
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== nextStep){
			turn.changeState();
			if (ChalmeRisk.turnModel.getCurrentStateIndex() == 0) {
				nextStep.setEnabled(false);
				ChalmeRisk.movementModel.allowTroopMovement();
			}
		}
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		if (ChalmeRisk.turnModel.getCurrentStateIndex() == 0) {
			reinforcementPanel.setVisible(true);
			reinforcementPanel.setLocation(((int)getMousePosition().getX()), ((int)getMousePosition().getY() - 50));
			validate();
		}
		else {
			reinforcementPanel.setVisible(false);
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent arg0) {
		if (ChalmeRisk.turnModel.getCurrentStateIndex() == 0) {
			reinforcementPanel.setVisible(true);
			try {
				reinforcementPanel.setLocation(((int)getMousePosition().getX()), ((int)getMousePosition().getY() - 50));
			}
				catch (NullPointerException e) {
					//Do nothing.
			}
			validate();	
		}
		else {
			reinforcementPanel.setVisible(false);
		}
	}

	@Override
	public void update(Observable observable, Object arg) {
		if(observable.equals(ChalmeRisk.round.getCurrentPlayer())){
			if(arg.equals(Integer.valueOf(0))){
				if(ChalmeRisk.round.getCurrentPlayer().getReinforcements()==0){
					nextStep.setEnabled(true);	
				}
			}
		}
	}
}

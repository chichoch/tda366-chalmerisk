package edu.chl.chalmerisk.risk.view;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import edu.chl.chalmerisk.risk.constants.Country;
import edu.chl.chalmerisk.risk.core.ChalmeRisk;

public class CountryView extends JPanel implements Observer , MouseListener{
	private JLabel troopDisplay;
	private ImageIcon icon;
	private JLabel troopIcon;
	private Country country;
	
	public CountryView(Country country){
		this.country = country;
		country.addObserver(this);
		setLayout(new FlowLayout());
		icon = ChalmeRisk.iconHandler.getIcon(country.getOwner(), country.getTroops());
		troopIcon = new JLabel();
		troopDisplay = new JLabel(""+country.getTroops());
		troopIcon.setIcon(icon);
		add(troopIcon);
		add(troopDisplay);
		setPreferredSize(new Dimension(75,75));
		setOpaque(false);
		country.addObserver(this);
		addMouseListener(this);
		}
	
	@Override
	public void update(Observable observable, Object arg) {
		if(observable.equals(country)){
			if(arg.equals(new Integer(0))){
				troopDisplay.setText(""+country.getTroops());
				troopIcon.setIcon(ChalmeRisk.iconHandler.getIcon(country.getOwner(), country.getTroops()));
			}
			if(arg.equals(new Integer(1))){
				troopIcon.setIcon(ChalmeRisk.iconHandler.getIcon(country.getOwner(), country.getTroops()));
			}
			/*if(arg.equals(new Integer(2))){
				if(country.isSelected()){
					
				}
				else{
					
				}
			}*/
		}
	}

	public Country getCountry() {
		return country;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		//if(ChalmeRisk.turn.getCurrentStateIndex() == 1 && this.country.getOwner().equals(ChalmeRisk.round.getCurrentPlayer())){
		//	System.out.println("Steg 1");
		//	if(ChalmeRisk.aCtrl.getfirstCountrySelected()){
			//	System.out.println("Steg 2");
			//	troopIcon.setIcon(ChalmeRisk.iconHandler.getSelectedIcon(country.getOwner(), country.getTroops()));
		//	}
	//	}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		/**
		if(this.country.getOwner().equals(ChalmeRisk.round.getCurrentPlayer())){
			troopIcon.setIcon(ChalmeRisk.iconHandler.getSelectedIcon(country.getOwner(), country.getTroops()));
		}
		**/
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		/**
		if(troopIcon.getIcon() != ChalmeRisk.iconHandler.getAttackerIcon(country.getOwner(), country.getTroops())){
			troopIcon.setIcon(ChalmeRisk.iconHandler.getIcon(country.getOwner(), country.getTroops()));	
		}
		**/
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
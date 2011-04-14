package edu.chl.chalmerisk.risk.view;

import java.awt.*;
import edu.chl.chalmerisk.risk.*;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;


import edu.chl.chalmerisk.risk.constants.Country;
import edu.chl.chalmerisk.risk.core.Builder;


public class CountryView extends JPanel implements Observer{
	private JLabel troopDisplay;
	private ImageIcon icon;
	private JLabel troopIcon;
	private Country country;
	
	public CountryView(Country country){
		this.country = country;
		setLayout(new FlowLayout());
		icon = Builder.iconHandler.getIcon(country.getOwner(), country.getTroops());
		troopIcon = new JLabel();
		troopDisplay = new JLabel("1");
		troopIcon.setIcon(icon);
		add(troopIcon);
		add(troopDisplay);
		setPreferredSize(new Dimension(60,75));
		setOpaque(false);
		country.addObserver(this);
		
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		if(observable.equals(country)){
			System.out.println("Ja");
			if(arg.equals(new Integer(0))){
				troopDisplay.setText(""+country.getTroops());
			}
			if(arg.equals(new Integer(1))){
				troopIcon.setIcon(Builder.iconHandler.getIcon(country.getOwner(), country.getTroops()));
			}
		}
	}
}
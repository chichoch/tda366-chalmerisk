package edu.chl.chalmerisk.risk.view;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import edu.chl.chalmerisk.risk.core.ChalmeRisk;
import edu.chl.chalmerisk.risk.core.Country;

public class CountryView extends JPanel implements Observer {
	private JLabel troopDisplay;
	private ImageIcon icon;
	private JLabel troopIcon;
	private Country country;
	
	public CountryView(Country country){
		this.country = country;
		country.addObserver(this);
		setLayout(new FlowLayout());
		icon = ViewBuilder.iconHandler.getIcon(country.getOwner(), country.getTroops());
		troopIcon = new JLabel();
		troopDisplay = new JLabel(""+country.getTroops());
		troopIcon.setIcon(icon);
		add(troopIcon);
		add(troopDisplay);
		setPreferredSize(new Dimension(75,75));
		setOpaque(false);
		country.addObserver(this);
		}
	
	@Override
	public void update(Observable observable, Object arg) {
		if(observable.equals(country)){
			if(arg.equals(new Integer(0))){
				troopDisplay.setText(""+country.getTroops());
				troopIcon.setIcon(ViewBuilder.iconHandler.getIcon(country.getOwner(), country.getTroops()));
			}
			if(arg.equals(new Integer(1))){
				troopIcon.setIcon(ViewBuilder.iconHandler.getIcon(country.getOwner(), country.getTroops()));
			}
			if(arg.equals(new Integer(2))){
				if(country.isSelected()){
					troopIcon.setIcon(ViewBuilder.iconHandler.getSelectedIcon(country.getOwner(), country.getTroops()));
				}
				else{
					troopIcon.setIcon(ViewBuilder.iconHandler.getIcon(country.getOwner(), country.getTroops()));
				}
			}
		}
	}

	public Country getCountry() {
		return country;
	}
}
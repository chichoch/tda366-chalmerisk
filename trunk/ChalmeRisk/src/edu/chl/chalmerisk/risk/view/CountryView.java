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
	
	public CountryView(Country country){
		setLayout(new FlowLayout());
		icon = Builder.iconHandler.getIcon(Builder.map.getCountry(1).getOwner(), Builder.map.getCountry(1).getTroops());
		troopIcon = new JLabel();
		troopDisplay = new JLabel("14");
		troopIcon.setIcon(icon);
		add(troopIcon);
		add(troopDisplay);
		setPreferredSize(new Dimension(75,75));
	}
	
	@Override
	public void update(Observable Country, Object arg) {
		System.out.println("blah");
	}
}
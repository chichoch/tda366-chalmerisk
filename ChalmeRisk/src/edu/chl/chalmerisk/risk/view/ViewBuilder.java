package edu.chl.chalmerisk.risk.view;

import edu.chl.chalmerisk.risk.core.ChalmeRisk;
import edu.chl.chalmerisk.risk.core.IconHandler;

/**
 * Builder for the View.
 * Contains the View-elements of the application.
 * (Except the menu)
 */

public class ViewBuilder {
	public static MainFrame guiTest;
	public static MovementDialog movement;
	public static AttackDialog attack;
	public static IconHandler iconHandler;
	
	public ViewBuilder(){
		build();
	}
	
	private static void build(){
		 movement = new MovementDialog();
		 attack = new AttackDialog();
		 iconHandler  = new IconHandler();
		 guiTest = new MainFrame(ChalmeRisk.map.getCountries());
	}
}

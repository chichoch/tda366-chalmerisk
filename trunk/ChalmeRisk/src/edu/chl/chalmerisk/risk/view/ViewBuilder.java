package edu.chl.chalmerisk.risk.view;

import java.util.Observable;
import java.util.Observer;

import edu.chl.chalmerisk.risk.core.ChalmeRisk;
import edu.chl.chalmerisk.risk.core.IconHandler;

public class ViewBuilder {
	public static MainFrame guiTest;
	public static MovementDialog movement;
	public static AttackDialog attack;
	public static IconHandler iconHandler;
	
	public ViewBuilder(){
		 movement = new MovementDialog();
		 attack = new AttackDialog();
		 iconHandler  = new IconHandler();
		 guiTest = new MainFrame(ChalmeRisk.map.getCountries());
	}
}

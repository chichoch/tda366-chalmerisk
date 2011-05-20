package edu.chl.chalmerisk.risk.core;

import java.io.FileNotFoundException;
import java.util.List;
import edu.chl.chalmerisk.risk.ctrl.*;
import edu.chl.chalmerisk.risk.util.*;
import edu.chl.chalmerisk.risk.view.*;



public class ChalmeRisk {
	//Imutable 
	public static Map map;
	public static RandomizeCountries random;
	//TODO Move to view.
	public static IconHandler iconHandler;
	//TODO Move to View.
	public static MainFrame guiTest;
	//TODO Runtime
	public static MovementDialog movement = new MovementDialog();
	//TODO Runtime
	public static DiceController dCtrl = new DiceController();
	public static AttackDialog attack = new AttackDialog();
	public static AttackController aCtrl = new AttackController();
	public static ReinforcementController rCtrl = new ReinforcementController();
	public static TroopMovementController tCtrl = new TroopMovementController();
	
	public static InfoModel infoModel;
	public static Turn turn;
	public static Round round;
	public static RandomizeCountries randomizer;

	public ChalmeRisk(List<Player> pList, String filename) throws FileNotFoundException {
		
		map = new Map("maps/"+filename+".txt");
		randomizer = new RandomizeCountries();
		map.setCountries(randomizer.randomize(pList, map.getCountries()));
		iconHandler  = new IconHandler();
		turn = new Turn();
		round = new Round(pList);
		infoModel = new InfoModel();
		guiTest = new MainFrame(map.getCountries());
	}
}


package edu.chl.chalmerisk.risk.core;

import java.io.FileNotFoundException;
import java.util.List;
import edu.chl.chalmerisk.risk.constants.Map;
import edu.chl.chalmerisk.risk.constants.Player;
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
	public static AttackDialog attack = new AttackDialog();
	public static AttackController aCtrl = new AttackController();
	public static ReinforcementController rCtrl = new ReinforcementController();
	public static TroopMovementController tCtrl = new TroopMovementController();
	public static DiceController diceC = new DiceController();
	public static Turn turn = new Turn();
	public static Round round;
	public static RandomizeCountries randomizer;

	public ChalmeRisk(List<Player> pList, String filename) throws FileNotFoundException {
		
		map = new Map("maps/"+filename+".txt");
		randomizer = new RandomizeCountries();
		map.setCountries(randomizer.randomize(pList, map.getCountries()));
		iconHandler  = new IconHandler();
		guiTest = new MainFrame(map.getCountries());

		round = new Round(pList);
	}
}


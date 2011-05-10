package edu.chl.chalmerisk.risk.core;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import edu.chl.chalmerisk.risk.constants.Map;
import edu.chl.chalmerisk.risk.constants.Player;
import edu.chl.chalmerisk.risk.ctrl.*;
import edu.chl.chalmerisk.risk.util.*;
import edu.chl.chalmerisk.risk.view.*;



public class ChalmeRisk {
	public static Player player1 = new Player(Color.RED, "Fredrik");
	public static Player player2 = new Player(Color.GREEN, "Christope");
	private static List<Player> pList = new ArrayList<Player>();
	//Imutable 
	public static Map map;
	public static RandomizeCountries random;
	//TODO Move to view.
	public static IconHandler iconHandler;
	//TODO MOve to View.
	public static MainFrame guiTest;
	//TODO Runtime
	public static MovementDialog movement = new MovementDialog();
	//TODO Runtime
	public static AttackDialog attack = new AttackDialog();
	public static AttackController aCtrl = new AttackController();
	public static ReinforcementController rCtrl = new ReinforcementController();
	public static TroopMovementController tCtrl = new TroopMovementController();
	public static MenuController mCtrl = new MenuController();
	public static DiceController diceC = new DiceController();
	public static Turn turn = new Turn();
	public static Round round;
	
	public ChalmeRisk() throws FileNotFoundException{
		map = new Map("maps/testmap.txt");
		setPlayers();
		iconHandler  = new IconHandler();
		guiTest = new MainFrame(map.getCountries());
		
		pList.add(player1);
		pList.add(player2);
		round = new Round(pList);
	}
	
	//An ugly preliminary method to set the players in the game.
	public void setPlayers() {
		map.setPlayer(player1, 1);
		map.setPlayer(player1, 2);
		map.setPlayer(player2, 3);
		map.setPlayer(player2, 4);
		
	}
}


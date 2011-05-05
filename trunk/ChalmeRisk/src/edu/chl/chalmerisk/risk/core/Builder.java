package edu.chl.chalmerisk.risk.core;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import edu.chl.chalmerisk.risk.constants.Map;
import edu.chl.chalmerisk.risk.constants.Player;
import edu.chl.chalmerisk.risk.ctrl.*;
import edu.chl.chalmerisk.risk.io.MapBuilder;
import edu.chl.chalmerisk.risk.view.*;



public class Builder {
	public static Player player1 = new Player(Color.RED, "Fredrik");
	public static Player player2 = new Player(Color.GREEN, "Christope");
	private static List<Player> pList = new ArrayList<Player>();
	public static Map map;
	public static IconHandler iconHandler;
	public static GUItest guiTest;
	public static AttackDialog attack = new AttackDialog();
	public static MovementDialog movement = new MovementDialog();
	public static AttackController aCtrl = new AttackController();
	public static ReinforcementController rCtrl = new ReinforcementController();
	public static TroopMovementController tCtrl = new TroopMovementController();
	public static DiceController diceC = new DiceController();
	public static Turn turn = new Turn();
	public static Round round;
	public Builder() throws FileNotFoundException{
		map = new Map("maps/testmap.txt");
		setPlayers();
		iconHandler  = new IconHandler();
		guiTest = new GUItest();
		
		pList.add(player1);
		pList.add(player2);
		round = new Round(pList);
	}
	
	//A preliminary method to set the players in the game.
	public void setPlayers() {
		map.setPlayer(player1, 1);
		map.setPlayer(player1, 2);
		map.setPlayer(player2, 3);
		map.setPlayer(player2, 4);
	}
}


package edu.chl.chalmerisk.risk.core;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * This class works as a Builder for the whole game.
 */
public class ChalmeRisk {
	
	public static Map map;
	public static InfoModel infoModel;
	public static Round round;
	public static RandomizeCountries randomizer;
	public static AttackModel attackModel;
	public static MovementModel movementModel;
	public static TurnModel turnModel;
	
	public ChalmeRisk(List<Player> pList, String filename ) throws FileNotFoundException {
		build(pList, filename);
	}
	private static void build(List<Player> pList, String filename) throws FileNotFoundException{
		map = new Map("maps/"+filename+".txt");
		turnModel = new TurnModel();
		randomizer = new RandomizeCountries();
		randomizer.randomize(pList, map.getCountries());
		round = new Round(pList);
		infoModel = new InfoModel();
		attackModel = new AttackModel();
		movementModel = new MovementModel();
	}
}


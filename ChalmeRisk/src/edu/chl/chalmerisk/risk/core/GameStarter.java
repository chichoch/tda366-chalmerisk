package edu.chl.chalmerisk.risk.core;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import edu.chl.chalmerisk.risk.core.ChalmeRisk;
import edu.chl.chalmerisk.risk.core.Player;
import edu.chl.chalmerisk.risk.view.ViewBuilder;

/**
 * Starts the game with the information it gets from its constructor.
 *
 */
public class GameStarter {
	private static List<Player> pList = new ArrayList<Player>();
	
	public GameStarter(String player1, String player2, String player3, String player4, String map) throws FileNotFoundException{
		if(player1.isEmpty()==false){
			Player PlayerOne = new Player(Color.RED, player1);
			pList.add(PlayerOne);
		}
		if(player2.isEmpty()==false){
			Player PlayerTwo = new Player(Color.GREEN, player2);
			pList.add(PlayerTwo);
		}
		if(player3.isEmpty()==false){
			Player PlayerThree = new Player(Color.YELLOW, player3);
			pList.add(PlayerThree);
		}
		if(player4.isEmpty()==false){
			Player PlayerFour = new Player(Color.BLUE, player4);
			pList.add(PlayerFour);
		}
		new ChalmeRisk(pList, map);
		new ViewBuilder();
	}
}

package edu.chl.chalmerisk.risk.core;

import java.util.ArrayList;
import java.util.List;

import edu.chl.chalmerisk.risk.constants.Player;
import edu.chl.chalmerisk.risk.util.ReinforcementCalculator;

public class Round {
	private List<Player> pList = new ArrayList<Player>();
	private Player currentPlayer;
	private int numOfPlayers;
	private ReinforcementCalculator rCalc = new ReinforcementCalculator();
	
	public Round(List<Player> list) {
		pList = list;
		currentPlayer = pList.get(0);
		numOfPlayers = pList.size();
	}
	
	public void newRound() {
		try {
			System.out.println("" + currentPlayer.getName() + " "+ pList.indexOf(currentPlayer));
			currentPlayer = pList.get(pList.indexOf(currentPlayer) + 1);
			numOfPlayers = pList.size();
		}
		catch (IndexOutOfBoundsException e){
			numOfPlayers = pList.size();
			currentPlayer = pList.get(0);
			rCalc.setReinforcements(pList);
		}
		
	}
	public int getNumberOfPlayers() {
		return numOfPlayers;
	}
	
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	
	public List<Player> getPlayerList() {
		return pList;
	}
}

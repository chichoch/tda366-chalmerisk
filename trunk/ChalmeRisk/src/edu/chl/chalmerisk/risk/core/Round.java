package edu.chl.chalmerisk.risk.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import edu.chl.chalmerisk.risk.constants.Player;
import edu.chl.chalmerisk.risk.util.ActivePlayers;
import edu.chl.chalmerisk.risk.util.ReinforcementCalculator;

public class Round extends Observable{
	private List<Player> pList = new ArrayList<Player>();
	private Player currentPlayer;
	private int numOfPlayers;
	
	public Round(List<Player> list) {
		pList = list;
		currentPlayer = pList.get(0);
		numOfPlayers = pList.size();
		//Set the reinforcements.
		ReinforcementCalculator.getInstance().setReinforcements(pList);
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
			//TODO Check the countries for players. Set pList to the players that are still alive.
			//pList = ActivePlayers.getInstance().getActivePlayers(ChalmeRisk.map.getCountries());
			//When its a new round set the reinforcements for the players.
			ReinforcementCalculator.getInstance().setReinforcements(pList);
		}
		setChanged();
		notifyObservers(0);
		
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

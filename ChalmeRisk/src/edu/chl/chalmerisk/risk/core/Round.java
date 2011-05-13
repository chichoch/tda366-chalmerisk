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
	private int currentNumber;
	private int numOfPlayers;
	
	public Round(List<Player> list) {
		pList = list;
		currentPlayer = pList.get(0);
		numOfPlayers = pList.size();
		currentNumber = -1;
		//Set the reinforcements.
		ReinforcementCalculator.getInstance().setReinforcements(pList);
	}
	
	public void newRound() {
		
		try {
			if(ActivePlayers.getInstance().getActivePlayers(pList.get(currentNumber+1))){
				currentPlayer = pList.get(pList.indexOf(currentPlayer) + 1);
				numOfPlayers = pList.size();
				currentNumber++;
				if(currentNumber+1 == numOfPlayers){
					currentNumber = -1;
				}
			}
			else{
				pList.remove(currentNumber+1);
				numOfPlayers = pList.size();
				currentPlayer = pList.get(pList.indexOf(currentPlayer) + 1);
				currentNumber++;
				if(currentNumber+1 == numOfPlayers){
					currentNumber = -1;
				}
				newRound();
			}
			
		}
		catch (IndexOutOfBoundsException e){
			numOfPlayers = pList.size();
			currentPlayer = pList.get(0);
			//TODO Check the countries for players. Set pList to the players that are still alive.
			//pList = ActivePlayers.getInstance().getActivePlayers(ChalmeRisk.map.getCountries());
			//When its a new round set the reinforcements for the players.
			//ReinforcementCalculator.getInstance().setReinforcements(pList);
		}
		finally {
			setChanged();
			notifyObservers(0);
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

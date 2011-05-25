package edu.chl.chalmerisk.risk.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;


/**
 * This class keeps track of the players in the game.
 * @author christophe
 *
 */
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
		ReinforcementCalculator.getInstance().setFirstReinforcements(pList);
	}
	
	public void newRound(){
		
		try {
			if(ActivePlayers.getInstance().isActivePlayer(pList.get(currentNumber+1))){
				currentPlayer = pList.get(pList.indexOf(currentPlayer) + 1);
				numOfPlayers = pList.size();
				currentNumber++;
				if(currentNumber+1 == numOfPlayers){
					currentNumber = -1;
				}
			}
		}
		catch (IndexOutOfBoundsException e){
			numOfPlayers = pList.size();
			currentPlayer = pList.get(0);
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
	
	public int getCurrentNumber(){
		return currentNumber;
	}
	
	public List<Player> getPlayerList() {
		return pList;
	}
	
	public void updatePlayers(){
 	ActivePlayers.getInstance().getActivePlayers(getPlayerList());
	}
}

package edu.chl.chalmerisk.risk.util;

import java.util.ArrayList;
import java.util.List;

import edu.chl.chalmerisk.risk.core.ChalmeRisk;
import edu.chl.chalmerisk.risk.constants.Continent;
import edu.chl.chalmerisk.risk.constants.Country;
import edu.chl.chalmerisk.risk.constants.Player;

public class ReinforcementCalculator {
	private static ReinforcementCalculator instance;
	private List<Continent> conts = new ArrayList<Continent>();
	private List<Player> players = new ArrayList<Player>();
	private List<Country> countries = new ArrayList<Country>();
	
	private ReinforcementCalculator() {
		conts = ChalmeRisk.map.getContinents();
		countries = ChalmeRisk.map.getCountries();
	}
	
	public Player setReinforcements(Player player) {
		return setReinforcementsMain(player);
	}
	
	public List<Player> setFirstReinforcements(List<Player> pList) {
		return setReinforcementsFirstRounds(pList);
	}
	
	public List<Player> setReinforcementsFirstRounds(List<Player> pList) {
		players = pList;
		//Sets the players reinforcements after the official rules.
		int r = (50 - (5 * players.size()))/3;
		for (int p = 0; p < players.size(); p++) {
			players.get(p).setReinforcements(r);
		}
		System.out.println("First Rounds number of players: " + r);
		return pList;
	}
	
	public Player setReinforcementsMain(Player player) {
		
		//Set reinforcements based on continents.
		int contValue = 0;
		for (int i = 0; i < conts.size(); i++) {
			if (conts.get(i).getOwner().equals(player) && conts.get(i).getOwner() != null) {
				contValue = contValue + conts.get(i).getValue();
				//player.setMoreReinforcements(conts.get(i).getValue());
			}
		}
		
		//Set reinforcements based on how many countries each player owns.
		int numOfCountries = 0;
		for (int y = 0; y < countries.size(); y++){
			if (countries.get(y).getOwner().equals(player)) {
				numOfCountries++;
			}
		}
		if (numOfCountries > 9) {
			System.out.println("Normal Rounds number of players: " + ((numOfCountries/3)+ contValue));
			player.setMoreReinforcements((numOfCountries/3)+ contValue);
		}
		else{
			//Set every players reinforcements to the minimum (3):
			player.setReinforcements(contValue+3);
		}
		return player;
	}
	
	public static synchronized ReinforcementCalculator getInstance() {
		if (instance == null) {
			instance = new ReinforcementCalculator();
		}
		return instance;
	}
}

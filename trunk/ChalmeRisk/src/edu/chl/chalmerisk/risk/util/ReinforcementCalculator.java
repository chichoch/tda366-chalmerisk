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
	
	public List<Player> setReinforcements(List<Player> pList) {
		players = pList;
		//Set every players reinforcements to the minimum (3):
		for (int p = 0; p < players.size(); p++) {
			players.get(p).setReinforcements(3);
		}
		//Set reinforcements based on continents.
		for (int i = 0; i < conts.size(); i++) {
			for (int j = 0; j < players.size(); j++) {
				if (conts.get(i).getOwner().equals(players.get(j)) && conts.get(i).getOwner() != null) {
					players.get(j).setMoreReinforcements(conts.get(i).getValue());
				}
			}
		}
		//Set reinforcements based on how many countries each player owns.
		
		for (int x = 0; x < players.size(); x++) {
			int numOfCountries = 0;
			for (int y = 0; y < countries.size(); y++){
				if (countries.get(y).getOwner().equals(players.get(x))) {
					numOfCountries++;
				}
			}
			if (numOfCountries > 9) {
				players.get(x).setMoreReinforcements(numOfCountries/3);
			}
		}
		return players;
	}
	
	public static ReinforcementCalculator getInstance() {
		if (instance == null) {
			instance = new ReinforcementCalculator();
		}
		return instance;
	}
}

package edu.chl.chalmerisk.risk.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import edu.chl.chalmerisk.risk.core.ChalmeRisk;
import edu.chl.chalmerisk.risk.core.Continent;
import edu.chl.chalmerisk.risk.core.Country;
import edu.chl.chalmerisk.risk.core.Player;


/**
 * Calculates the Reinforcements. 
 *
 */
public class ReinforcementCalculator implements Observer{
	private static ReinforcementCalculator instance;
	private List<Continent> conts = new ArrayList<Continent>();
	private List<Player> players = new ArrayList<Player>();
	private List<Country> countries = new ArrayList<Country>();
	
	private ReinforcementCalculator() {
		ChalmeRisk.turnModel.addObserver(this);
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
		return pList;
	}
	
	public Player setReinforcementsMain(Player player) {
		conts = ChalmeRisk.map.getContinents();
		countries = ChalmeRisk.map.getCountries();
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
			player.setReinforcements((numOfCountries/3)+ contValue);
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

	@Override
	public void update(Observable observable, Object arg) {
		if (observable.equals(ChalmeRisk.turnModel)) {
			if(arg.equals(Integer.valueOf(0))){
				if (ChalmeRisk.turnModel.getCurrentStateIndex() == 0) {
					if(ChalmeRisk.turnModel.isFirstRound()){
						ReinforcementCalculator.getInstance().setReinforcementsFirstRounds(ChalmeRisk.round.getPlayerList());
					}
					else{;
						ReinforcementCalculator.getInstance().setReinforcements(ChalmeRisk.round.getCurrentPlayer());
					}
				}
			}
		}
	}
}

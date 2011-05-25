package edu.chl.chalmerisk.risk.core;
import java.util.ArrayList;
import java.util.List;

import edu.chl.chalmerisk.risk.core.ChalmeRisk;
import edu.chl.chalmerisk.risk.core.Country;
import edu.chl.chalmerisk.risk.core.Player;

/**
 * Checks if the player (or Players) are active.
 * @author christophe
 *
 */
public class ActivePlayers {
    private static ActivePlayers instance;
    private int count;
    private List<Player> currentList = ChalmeRisk.round.getPlayerList();
    private ActivePlayers() {
   	 
    }
  
    public boolean isActivePlayer(Player player) {
    	count = 0;
    	List<Country> cList = new ArrayList<Country>();
    	cList = ChalmeRisk.map.getCountries();
    	for (int i = 0; i < cList.size(); i++) {
    		if(cList.get(i).getOwner().equals(player)){
    			count++;
    		}
    	}
    	if(count == 0){
    		return false; 		 
    	}
    	return true;
    }
    
    public List<Player> getActivePlayers(List <Player> pList) {
    	for(int i = 0; i<pList.size(); i++){
    		if(!isActivePlayer(pList.get(i))){
    			currentList.remove(pList.get(i));
    		}
    	}
    	return currentList;
    }
    
 
    public static synchronized ActivePlayers getInstance() {
   	 if(instance == null){
   		 instance = new ActivePlayers();
   	 }
   	 return instance;
    }
}
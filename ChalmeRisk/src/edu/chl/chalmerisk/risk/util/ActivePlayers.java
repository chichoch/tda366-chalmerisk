package edu.chl.chalmerisk.risk.util;
import java.util.ArrayList;
import java.util.List;
 
import edu.chl.chalmerisk.risk.constants.*;
import edu.chl.chalmerisk.risk.core.ChalmeRisk;
 
public class ActivePlayers {
    private static ActivePlayers instance;
    private int count;
    private ActivePlayers() {
   	 
    }
  
    public boolean getActivePlayers(Player player) {
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
 
    public static synchronized ActivePlayers getInstance() {
   	 if(instance == null){
   		 instance = new ActivePlayers();
   	 }
   	 return instance;
    }
}
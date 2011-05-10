package edu.chl.chalmerisk.risk.util;
import java.util.List;

import edu.chl.chalmerisk.risk.constants.*;

public class ActivePlayers {
	private static ActivePlayers instance;
	
	private ActivePlayers(){
		
	}
	
	public List<Player> getActivePlayers(List<Country> cList, List<Player> pList){
		return pList;
	}
	
	public static synchronized ActivePlayers getInstance(){
		if(instance == null){
			instance = new ActivePlayers();
		}
		return instance;
	}
}

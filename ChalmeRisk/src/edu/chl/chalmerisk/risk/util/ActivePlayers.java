package edu.chl.chalmerisk.risk.util;
import java.util.ArrayList;
import java.util.List;

import edu.chl.chalmerisk.risk.constants.*;
import edu.chl.chalmerisk.risk.core.GameOverException;

public class ActivePlayers {
	private static ActivePlayers instance;
	
	private ActivePlayers(){
		
	}
	
	public List<Player> getActivePlayers(List<Country> cList) {
		List<Player> pList = new ArrayList<Player>();
		pList.add(cList.get(0).getOwner());
		for (int i = 0; i < cList.size(); i++) {
			for (int j = 0; j < pList.size(); j++) {
				if (!cList.get(i).getOwner().equals(pList.get(j))) {
					pList.add(cList.get(i).getOwner());
				}
			}
		}
		if (pList.size() == 1) {
			//throw new GameOverException();
		}
		return pList;
	}
	
	public static synchronized ActivePlayers getInstance(){
		if(instance == null){
			instance = new ActivePlayers();
		}
		return instance;
	}
}

package edu.chl.chalmerisk.risk.core;

import java.util.ArrayList;
import java.util.List;
import edu.chl.chalmerisk.risk.core.ChalmeRisk;
import edu.chl.chalmerisk.risk.core.Country;
import edu.chl.chalmerisk.risk.core.Player;

/** This is a class that randomizes the Countries for
 * the players in the start of each game 
 */

public class RandomizeCountries {
	private int id;
	private int index = 0;
	private int indexplayer; 
	private List<Country> copyList = new ArrayList<Country>();
	
	public  void randomize (List <Player> pList, List<Country> cList){
		int l = cList.size();
		for (int j=0; j<l; j++){
			id = (int)(Math.random()*cList.size());
			copyList.add(cList.get(id));
			cList.remove(id);    
		}
		indexplayer =(int)(Math.random()*pList.size());
		while(!copyList.isEmpty()){
			cList.add(copyList.get(0));
			cList.get(index).setOwner(pList.get(indexplayer));
			copyList.remove(0);
			index=index+1;
			indexplayer = indexplayer +1;
			if(indexplayer == pList.size()){
				indexplayer = 0;
			}
		}
		ChalmeRisk.map.setCountries(cList);
	}	
}

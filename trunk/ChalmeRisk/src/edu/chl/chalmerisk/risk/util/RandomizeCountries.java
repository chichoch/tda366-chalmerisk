package edu.chl.chalmerisk.risk.util;

import java.util.ArrayList;
import java.util.List;
import edu.chl.chalmerisk.risk.core.ChalmeRisk;
import edu.chl.chalmerisk.risk.core.Country;
import edu.chl.chalmerisk.risk.core.Player;

/* This is a class that randomizes the Countries for
 * the players in the start of each game 
 */


public class RandomizeCountries {
	private int id;
	private int index = 0;
	private int indexplayer; 
	private List<Country> copyList = new ArrayList<Country>();
	/*
	public  List<Country> randomize (List <Player> pList, List<Country> cList){
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
		return cList;
	}
	*/
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
/*
public static void main(String[] args){
		Player random = new Player(Color.ORANGE, "Random");
		Country Norge = new Country("Norge", 1, 233, 233, 1, new int[5], random);
		Country Sverige = new Country("Sverige", 2, 233, 233, 1, new int[5], random);
		Country Finland = new Country("Finland", 3, 233, 233, 1, new int[5], random);
		Country Danmark = new Country("Danmark", 4, 233, 233, 1, new int[5], random);
		Country Ryssland = new Country("Ryssland", 5, 233, 233, 1, new int[5], random);
		Country Holland = new Country("Holland", 6, 233, 233, 1, new int[5], random);
		Country Usa = new Country("Usa", 6, 233, 233, 1, new int[5], random);
		Country England = new Country("England", 7, 233, 233, 1, new int[5], random);
		Country Irland = new Country("Irland", 8, 233, 233, 1, new int[5], random);
		Country Belgien = new Country("Belgien", 9, 233, 233, 1, new int[5], random);
		Country Japan = new Country("Japan", 10, 233, 233, 1, new int[5], random);
		List<Country> lander = new ArrayList<Country>();
		lander.add(Norge);
		lander.add(Sverige);
		lander.add(Finland);
		lander.add(Danmark);
		lander.add(Ryssland);
		lander.add(Usa);
		lander.add(Holland);
		lander.add(England);
		lander.add(Irland);
		lander.add(Belgien);
		lander.add(Japan);
		Player alex = new Player(Color.BLACK, "Alex");
		Player fredrik = new Player(Color.WHITE, "Fredrik");
		Player jocke = new Player(Color.RED, "Jocke");
		List<Player> spelare = new ArrayList<Player>();
		spelare.add(alex);
		spelare.add(fredrik);
		spelare.add(jocke);
		lander=randomize(spelare, lander);
		for(int i = 0; i<lander.size(); i++){
			System.out.println(lander.get(i).getName()+" "+ lander.get(i).getOwner().getName());
		}
	}
}*/

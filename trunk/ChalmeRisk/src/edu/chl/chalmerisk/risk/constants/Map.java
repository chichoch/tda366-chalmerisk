package edu.chl.chalmerisk.risk.constants;
import java.io.FileNotFoundException;
import java.util.List;

import edu.chl.chalmerisk.risk.io.MapBuilder;


public class Map {
	private MapBuilder map;
	private List<Country> list;
	private String iconFileName;
	
	public Map(String filename) throws FileNotFoundException {
		map = new MapBuilder(filename);
		list = map.getCountries();
		iconFileName = map.getIconFileName();
	}
	//Returns the specific ID of each country
	public Country getCountry(int id) {
 		for (int i = 0; i < list.size(); i++) {
 			if (list.get(i).getCountryId() == id) {
 				return list.get(i);
 			}
 		}
 		return null;
 	}
	
	public String getIconFileName() {
		return iconFileName;
	}
	
	public void setPlayer(Player p, int countryId) {
		for (int i = 0; i < list.size(); i++) {
 			if (list.get(i).getCountryId() == countryId) {
 				list.get(i).setOwner(p);
 			}
 		}
	}
	
	public List<Country> getCountries() {
		return list;
	}
}

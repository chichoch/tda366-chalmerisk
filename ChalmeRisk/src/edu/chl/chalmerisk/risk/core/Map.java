package edu.chl.chalmerisk.risk.core;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * This class holds the information about the whole Map.
 * Gets its information from the MapBuilder (The subsystem)
 * and contains the countries and continents.
 *
 */

public class Map {
	private MapBuilder map;
	private List<Country> countryList;
	private List<Continent> continentList;
	private String iconFileName;
	
	public Map(String filename) throws FileNotFoundException {
		map = new MapBuilder(filename);
		countryList = map.getCountries();
		iconFileName = map.getIconFileName();
		continentList = map.getContinents();
	}
	
	//Returns the specific ID of each country
	public Country getCountry(int id) {
 		for (int i = 0; i < countryList.size(); i++) {
 			if (countryList.get(i).getCountryId() == id) {
 				return countryList.get(i);
 			}
 		}
 		return null;
 	}
	
	public String getIconFileName() {
		return iconFileName;
	}
	
	public void setCountries(List<Country> cList){
		countryList = cList;
	}
	
	public void setContinents(List<Continent> cList) {
		continentList = cList;
	}
	
	public void setPlayer(Player p, int countryId) {
		for (int i = 0; i < countryList.size(); i++) {
 			if (countryList.get(i).getCountryId() == countryId) {
 				countryList.get(i).setOwner(p);
 			}
 		}
	}
	
	public List<Country> getCountries() {
		return countryList;
	}
	
	public List<Continent> getContinents() {
		return continentList;
	}
}

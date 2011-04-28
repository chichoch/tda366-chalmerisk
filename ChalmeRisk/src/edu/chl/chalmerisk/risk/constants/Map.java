package edu.chl.chalmerisk.risk.constants;
import edu.chl.chalmerisk.risk.core.Builder;


public class Map {
	private int[] norgeGrannar = {2,3};
	private int[] finlandGrannar = {1,2};
	private int[] sverigeGrannar = {1,3,4};
	private int[] danmarkGrannar = {2};
	private Country Norge = new Country("Norge", 1, 2, norgeGrannar, Builder.player1);
	private Country Sverige = new Country("Sverige", 2, 4, sverigeGrannar, Builder.player1);
	private Country Finland = new Country("Finland", 3, 6, finlandGrannar, Builder.player1);
	private Country Danmark = new Country("Danmark", 4, 3, danmarkGrannar, Builder.player2);
	

	//Returns the specific ID of each country
	public Country getCountry(int i){
		if(Norge.getCountryId() == i){ 
			return Norge;
		}
		if(Sverige.getCountryId() == i){ 
			return Sverige;
		}
		if(Finland.getCountryId()== i){ 
			return Finland;
		}
		return Danmark;
		
	}
	 
}

import javax.swing.JOptionPane;


public class Map {
	
	private Country Norge = new Country("Norge", 1, 10);
	private Country Sverige = new Country("Sverige", 2, 10);
	private Country Finland = new Country("Finland", 3, 10);
	private Country Danmark = new Country("Danmark", 4, 10);
	//A Country that indicates that something is wrong.
	private Country empty = new Country("EMPTY COUNTRY", "ERROR", 3);
	//private Country Chalmers = new Country("Chalmers");
	//private Country Chalmers = new Country("Chalmers");
	//private Country Chalmers = new Country("Chalmers");

	
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
		if(Danmark.getCountryId()== i){ 
			return Danmark;
		}
		return empty;
	}
	 
}

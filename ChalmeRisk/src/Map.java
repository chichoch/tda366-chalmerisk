import javax.swing.JOptionPane;


public class Map {
	private int[] norgeGrannar = {2,3};
	private int[] finlandGrannar = {1,2};
	private int[] sverigeGrannar = {1,3,4};
	private int[] danmarkGrannar = {2};
	private Country Norge = new Country("Norge", 1, 10, new Neighbours(norgeGrannar));
	private Country Sverige = new Country("Sverige", 2, 10, new Neighbours(sverigeGrannar) );
	private Country Finland = new Country("Finland", 3, 10, new Neighbours(finlandGrannar));
	private Country Danmark = new Country("Danmark", 4, 10, new Neighbours(danmarkGrannar));
	//A Country that indicates that something is wrong.
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
		return Danmark;
		
	}
	 
}

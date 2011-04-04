
public class Map {
	
	private Country Chalmers = new Country("Chalmers", 1);
	private Country Chalmers2 = new Country("Chalmers", 2);
	//private Country Chalmers = new Country("Chalmers");
	//private Country Chalmers = new Country("Chalmers");
	//private Country Chalmers = new Country("Chalmers");

	public Country getCountry(int i){
		if(Chalmers.getCountryId()== i){ 
			return Chalmers;
		}
		if(Chalmers2.getCountryId()== i){ 
			return Chalmers2;
		}
		return null;
	}
}

import javax.swing.JOptionPane;


public class Map {
	private int[] norgeGrannar = {2,3};
	private int[] finlandGrannar = {1,2};
	private int[] sverigeGrannar = {1,3,4};
	private int[] danmarkGrannar = {2};
	private Country Norge = new Country("Norge", 1, 4, norgeGrannar, Builder.player1);
	private Country Sverige = new Country("Sverige", 2, 7, sverigeGrannar, Builder.player2);
	private Country Finland = new Country("Finland", 3, 12, finlandGrannar, Builder.player2);
	private Country Danmark = new Country("Danmark", 4, 18, danmarkGrannar, Builder.player1);

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

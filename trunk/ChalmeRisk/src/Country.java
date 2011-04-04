
public class Country {
	private int troops;
	private String country;
	private int countryid;
	private String owner;
	private String continent;
	public enum Neighbors {SVERIGE, NORGE};
	
	public Country() {
		
	}
	
	public Country(String s, int i, int f){
		country = s;
		countryid= i;
		troops= f;
	}
	
	public Country(String country, String owner, int troops){
		this.country = country;
		this.owner = owner;
		this.troops = troops;
	}
	
	public int getTroops() {
		return troops;
	}

	public String getOwner() {
		return owner;
	}
	public int getCountryId(){
		return countryid;
	}
	
	public void setTroops(int i) {
		troops = i;
	}
	
	public void setOwner(String s) {
		owner = s;
	}
	
	public String getContinent() {
		return continent;
	}
	public void setContinent(String e) {
		continent = e;
	}
}

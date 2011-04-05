
public class Country {
	private int troops;
	private String country;
	private int countryid;
	private Player owner;
	private String continent;
	public enum Neighbors {SVERIGE, NORGE};
	
	public Country() {
		
	}
	
	public Country(String s, int i, int f){
		this.country = s;
		this.countryid= i;
		this.troops= f;
	}
	
	public Country(String country, Player owner, int troops){
		this.country = country;
		this.owner = owner;
		this.troops = troops;
	}
	public String getName() {
		return country;
	}
	
	public int getTroops() {
		return troops;
	}

	public Player getOwner() {
		return owner;
	}
	public int getCountryId(){
		return countryid;
	}
	
	public void setTroops(int i) {
		troops = i;
	}
	
	public void setOwner(Player p) {
		owner = p;
	}
	
	public String getContinent() {
		return continent;
	}
	public void setContinent(String e) {
		continent = e;
	}
}

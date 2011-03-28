
public class Country {
	private int troops;
	private String country;
	private String owner;
	private String continent;
	public enum Neighbors {SVERIGE, NORGE};
	
	public Country(String s){
		country = s;
	}
	
	public int getTroops() {
		return troops;
	}

	public String getOwner() {
		return owner;
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


public class Country {
	private int troops;
	private String owner;
	private String continent;
	public enum Neighbors {SVERIGE, NORGE};
	
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
	public void getContinent(String e) {
		continent = e;
	}
	
	
}

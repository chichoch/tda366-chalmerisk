import java.util.List;


public class Country {
	private int troops;
	private String country;
	private int countryid;
	private Player owner;
	private String continent;
	private Neighbours neighbour;
	//private int[] grannar;

	public Country() {
		
	}
	
	public Country(String s, int id, int t, Neighbours n) {
		this.country = s;
		this.countryid = id;
		this.troops = t;
		this.neighbour = n;
	}
	

	/*
	public Country(String s, int id, int t, int[] n) {
		this.country = s;
		this.countryid = id;
		this.troops = t;
		this.grannar = n;
	}
	*/

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
	
	public boolean hasNeighbour(Country c){
		if ( neighbour.getNeighbours().contains(c) ){
			return true;	
		}
		return false;
	}
	
	public String getContinent() {
		return continent;
	}
	
	public void setContinent(String e) {
		continent = e;
	}
}

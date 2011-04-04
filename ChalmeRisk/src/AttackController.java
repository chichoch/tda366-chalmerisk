
public class AttackController {
	
	private Country c1;
	private Country c2;
	private Map map;
	private boolean firstCountrySelected = false;
	
	//Constructor
	public AttackController() {
		
	}
	
	public void setCountry(int id) {
		if (firstCountrySelected) {
			c2 = map.getCountry(id);
			new AttackDialog(c1, c2);
		}
		else {
			c1 = map.getCountry(id);
		}
	}
	
	public void startFight() {
	
	}
	
	public void endFight() {
		
	}
	
	
}

import javax.swing.JOptionPane;


public class AttackController {
	
	private Country c1;
	private Country c2;
	private Map map = new Map();
	private boolean firstCountrySelected;
	
	//Constructor
	public AttackController() {
		firstCountrySelected = false;
	}
	
	public void setCountry(int id) {
		
		 if (!firstCountrySelected) {
			firstCountrySelected = true;
			c1 = map.getCountry(id);
			JOptionPane.showMessageDialog(null, "Första landet markerat (" + map.getCountry(id).getName() + ")" );
	
			
		}
		else {
			c2 = map.getCountry(id);	
			JOptionPane.showMessageDialog(null, "Andra landet markerat (" + map.getCountry(id).getName() + ")" );
			firstCountrySelected = false;	
			new Attack(c1, c2);
		}	
	}
	
	public void startFight() {
		
	}
	
	//When you click "Invade" or "Retreat".
	public void endFight() {
		
	}
	
	
}

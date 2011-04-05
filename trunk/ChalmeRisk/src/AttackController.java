import javax.swing.JOptionPane;


public class AttackController {
	
	private Country attCountry;
	private Country defCountry;
	private Map map = new Map();
	private boolean firstCountrySelected;
	private AttackDialog attack = new AttackDialog();
	
	//Constructor
	public AttackController() {
		firstCountrySelected = false;
	}
	
	public void setCountry(int id) {
		
		 if (!firstCountrySelected) {
			firstCountrySelected = true;
			attCountry = map.getCountry(id);
			JOptionPane.showMessageDialog(null, "Första landet markerat (" + map.getCountry(id).getName() + ")" );
	
			
		}
		else {
			defCountry = map.getCountry(id);	
			JOptionPane.showMessageDialog(null, "Andra landet markerat (" + map.getCountry(id).getName() + ")" );
			firstCountrySelected = false;	
			attack.newAttack();
			attack.repaintTroops(attCountry.getTroops(), defCountry.getTroops());
			attack.setVisible(true);
			//new Attack(attCountry, defCountry);
		}	
	}
	
	public void startFight() {
		double i = Math.random()*10;
		if(i < 5){
			attCountry.setTroops(attCountry.getTroops() - 1);
			attack.setStatusText("Defender killed 1 ");
		}
		else if(i>=5){
			defCountry.setTroops(defCountry.getTroops() - 1);
			attack.setStatusText("Attacker killed 1 ");
		}
		if(attCountry.getTroops() == 1){
			attack.setDefenderWin();
		}
		if(defCountry.getTroops() == 0){
			//fight.setVisible(false);
			attack.setAttackerWin();	
		}
		attack.repaintTroops(attCountry.getTroops(), defCountry.getTroops());
	}
	
	//When you click "Invade" or "Retreat".
	public void endFight() {
		attack.setVisible(false);
	}
	
	
}

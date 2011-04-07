import javax.swing.JOptionPane;


public class AttackController {
	
	private Country attCountry;
	private Country defCountry;
	private boolean firstCountrySelected;
	private boolean takeOverCountry;
	
	//Constructor
	public AttackController() {
		takeOverCountry = false;
		firstCountrySelected = false;
	}
	
	public void setCountry(int id) {
		
		 if (!firstCountrySelected) {
			firstCountrySelected = true;
			attCountry = Builder.map.getCountry(id);
			JOptionPane.showMessageDialog(null, "Första landet markerat (" + Builder.map.getCountry(id).getName() + ")" );
	
			
		}
		else {
			defCountry = Builder.map.getCountry(id);	
			if (attCountry.hasNeighbour(id) == true) {
				JOptionPane.showMessageDialog(null, "Andra landet markerat (" + Builder.map.getCountry(id).getName() + ")" );
				firstCountrySelected = false;	
				Builder.attack.newAttack();
				Builder.attack.repaintTroops(attCountry.getTroops(), defCountry.getTroops());
				Builder.attack.setVisible(true);
				//new Attack(attCountry, defCountry);
			}
			else {
				JOptionPane.showMessageDialog(null, "Landet du vill attackera måste vara ett grannland!");
			}
		}	 
	}
	
	public void startFight() {
		double i = Math.random()*10;
		if(i < 5){
			attCountry.setTroops(attCountry.getTroops() - 1);
			Builder.attack.setStatusText("Defender killed 1 ");
		}
		else if(i>=5){
			defCountry.setTroops(defCountry.getTroops() - 1);
			Builder.attack.setStatusText("Attacker killed 1 ");
		}
		if(attCountry.getTroops() == 1){
			Builder.attack.setDefenderWin();
		}
		if(defCountry.getTroops() == 0){
			//fight.setVisible(false);
			Builder.attack.setAttackerWin();
			takeOverCountry = true;
		}
		Builder.attack.repaintTroops(attCountry.getTroops(), defCountry.getTroops());
	}
	
	//When you click "Invade" or "Retreat".
	public void endFight() {
		Builder.attack.setVisible(false);
		if(takeOverCountry == true){
			defCountry.setOwner(attCountry.getOwner());
			attCountry.setTroops(attCountry.getTroops()-1);
			defCountry.setTroops(1);
		}
	}
}

package edu.chl.chalmerisk.risk.view;

import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import edu.chl.chalmerisk.risk.core.Dice;
import edu.chl.chalmerisk.risk.ctrl.AttackController;

public class DiceView extends JLabel implements Observer {

	private Dice dice;
	private ImageIcon diceImageTom;
	private ImageIcon diceImage1;
	private ImageIcon diceImage2;
	private ImageIcon diceImage3;
	private ImageIcon diceImage4;
	private ImageIcon diceImage5;
	private ImageIcon diceImage6;

	public DiceView(Dice dice) {
		
		this.dice=dice;
		dice.addObserver(this);
		diceImageTom = new ImageIcon("resources/testdicetom.gif");
		diceImage1 = new ImageIcon("resources/testdice1.gif");
		diceImage2 = new ImageIcon("resources/testdice2.gif");
		diceImage3 = new ImageIcon("resources/testdice3.gif");
		diceImage4 = new ImageIcon("resources/testdice4.gif");
		diceImage5 = new ImageIcon("resources/testdice5.gif");
		diceImage6 = new ImageIcon("resources/testdice6.gif");
		setIcon(diceImageTom);
		
	
	}

	private boolean diceNotTossed(Dice dice){
		if(AttackController.dCtrl.getAttNumberOfDices()==2){
			if(this.dice == AttackController.dCtrl.getAttDice3()){
				return true;
			}
		}
		else if(AttackController.dCtrl.getAttNumberOfDices()==1){
			if(this.dice == AttackController.dCtrl.getAttDice3() || this.dice == AttackController.dCtrl.getAttDice2()){
				return true;
			}
		}
		if(AttackController.dCtrl.getDefNumberOfDices()==1){
			if(this.dice==AttackController.dCtrl.getDefDice2()){
				return true;
			}
		}
		return false;	
	}
	public void newDice(){
		setIcon(diceImageTom);
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		if(observable.equals(dice)){
			if(arg.equals(Integer.valueOf(0))){
				if(diceNotTossed(this.dice)){
					setIcon(diceImageTom); 
				}
				else{
					switch (dice.getNumber()) {
						case 1:  
							setIcon(diceImage1);      
							break;
						case 2:  
							setIcon(diceImage2);      
							break;
						case 3:  
							setIcon(diceImage3);         
							break;
						case 4:  
							setIcon(diceImage4);     
							break;
						case 5:  
							setIcon(diceImage5);
							break;
						case 6: 
							setIcon(diceImage6);         
							break;
						default:  
							setIcon(null);
							break;
					}
				}
			}
		}
	}
}
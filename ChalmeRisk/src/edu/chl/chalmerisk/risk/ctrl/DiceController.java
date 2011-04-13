package edu.chl.chalmerisk.risk.ctrl;
import edu.chl.chalmerisk.risk.*;

public class DiceController {

	public int winner;
	private int i;
	
	public int getResult() {
		
		i = (int) ((Math.random() * 5) + 1);
			if(i == 1){
				winner=1;
			}
			else if(i== 2){
				winner=2;
			}
			else if(i == 3){
				winner=3;
			}
			else if(i==4){
				winner=4;
			}
			else if(i==5){
				winner=5;
			}
	
	return winner;
	}
	
	
}

import java.awt.*;

import javax.swing.*;


public class PaintDice extends JFrame {

    private Dice attDice1,attDice2,attDice3; 
    private Dice defDice1,defDice2;

    PaintDice() {
	
    	setLayout(new BorderLayout());
    
        attDice1 = new Dice();
        attDice2 = new Dice();
        attDice3 = new Dice();
        defDice1 = new Dice();
        defDice2 = new Dice();
        
        setVisible(true);
		pack();
    }
        
	
}
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
        
        JPanel eastPanel = new JPanel();
        JPanel westPanel = new JPanel();
        /*
        westPanel.add(attDice1 , BorderLayout.WEST);
        westPanel.add(attDice2 , BorderLayout.WEST);
        westPanel.add(attDice3 , BorderLayout.WEST);
        eastPanel.add(defDice1, BorderLayout.EAST);
        eastPanel.add(defDice2, BorderLayout.EAST);
        
       */
        setVisible(true);
		pack();
    }
        
	
}
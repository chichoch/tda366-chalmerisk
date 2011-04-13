package edu.chl.chalmerisk.risk.view;


import java.awt.*;
import edu.chl.chalmerisk.risk.*;
import javax.swing.*;
import edu.chl.chalmerisk.risk.core.Dice;

public class PaintDice extends JFrame {

	private JPanel dicePanelEast;
	private JPanel dicePanelWest;
	private ImageIcon diceImage1;
	private ImageIcon diceImage2;
	private ImageIcon diceImage3;
	private ImageIcon diceImage4;
	private ImageIcon diceImage5;
	private ImageIcon diceImage6;
	private int attckingTroops;
	private int defendingTroops;

	public PaintDice() {

		attckingTroops=0;
		defendingTroops=0;

		Dice dice = new Dice();
		diceImage1 = new ImageIcon("testdice1.gif");
		diceImage2 = new ImageIcon("testdice2.gif");
		diceImage3 = new ImageIcon("testdice3.gif");
		diceImage4 = new ImageIcon("testdice4.gif");
		diceImage5 = new ImageIcon("testdice5.gif");
		diceImage6 = new ImageIcon("testdice6.gif");
		dicePanelWest = new JPanel();
		dicePanelEast = new JPanel();
		

		while(attckingTroops <=2 ){
			attckingTroops++;
			dice.tossDice();
			switch (dice.getNumber()) {
			case 1:  
				dicePanelWest.add(new JLabel(diceImage1));      
				break;
			case 2:  
				dicePanelWest.add(new JLabel(diceImage2));      
				break;
			case 3:  
				dicePanelWest.add(new JLabel(diceImage3));         
				break;
			case 4:  
				dicePanelWest.add(new JLabel(diceImage4));     
				break;
			case 5:  
				dicePanelWest.add(new JLabel(diceImage5));
				break;
			case 6: 
				dicePanelWest.add(new JLabel(diceImage6));         
				break;

			default:  
				break;
			}

		}
		while(defendingTroops <=1 ){
			defendingTroops++;
			dice.tossDice();
			switch (dice.getNumber()) {
			case 1:  
				dicePanelEast.add(new JLabel(diceImage1));      
				break;
			case 2:  
				dicePanelEast.add(new JLabel(diceImage2));      
				break;
			case 3:  
				dicePanelEast.add(new JLabel(diceImage3));         
				break;
			case 4:  
				dicePanelEast.add(new JLabel(diceImage4));     
				break;
			case 5:  
				dicePanelEast.add(new JLabel(diceImage5));
				break;
			case 6: 
				dicePanelEast.add(new JLabel(diceImage6));         
				break;
			default:  
				break;
			}

		}
		
		JFrame f = new JFrame("Dice window");
		
		f.setSize(500, 125);
		f.setLocation(500,500);
		f.getContentPane().add(BorderLayout.WEST, dicePanelWest );
		f.getContentPane().add(BorderLayout.EAST, dicePanelEast );
		f.setVisible(true);
	}
	public int getDiceNumber() {
		
		Dice dice = new Dice();
		return dice.getNumber();
	}


}
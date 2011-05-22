package edu.chl.chalmerisk.risk.core;
import java.awt.Color;

import javax.swing.ImageIcon;


public class IconHandler {
	ImageIcon redKnight = new ImageIcon("resources/KnightRed.gif");
	ImageIcon blueKnight = new ImageIcon("resources/KnightBlue.gif");
	ImageIcon yellowKnight = new ImageIcon("resources/KnightYellow.gif");
	ImageIcon greenKnight = new ImageIcon("resources/KnightGreen.gif");
	ImageIcon greenInfantrie = new ImageIcon("resources/greenInfantry.gif");
	ImageIcon redInfantrie = new ImageIcon("resources/redInfantry.gif");
	ImageIcon blueInfantrie = new ImageIcon("resources/blueInfantry.gif");
	ImageIcon yellowInfantrie = new ImageIcon("resources/yellowInfantry.gif");
	ImageIcon greenCannon = new ImageIcon("resources/greenCannon.gif");
	ImageIcon redCannon = new ImageIcon("resources/redCannon.gif");
	ImageIcon yellowCannon = new ImageIcon("resources/yellowCannon.gif");
	ImageIcon blueCannon = new ImageIcon("resources/blueCannon.gif");
	ImageIcon redKnightSelected = new ImageIcon("resources/KnightRedSelected.gif");
	ImageIcon blueKnightSelected = new ImageIcon("resources/KnightBlueSelected.gif");
	ImageIcon yellowKnightSelected = new ImageIcon("resources/KnightYellowSelected.gif");
	ImageIcon greenKnightSelected = new ImageIcon("resources/KnightGreenSelected.gif");
	ImageIcon greenInfantrieSelected = new ImageIcon("resources/greenInfantrySelected.gif");
	ImageIcon redInfantrieSelected = new ImageIcon("resources/redInfantrySelected.gif");
	ImageIcon blueInfantrieSelected = new ImageIcon("resources/blueInfantrySelected.gif");
	ImageIcon yellowInfantrieSelected = new ImageIcon("resources/yellowInfantrySelected.gif");
	ImageIcon greenCannonSelected = new ImageIcon("resources/greenCannonSelected.gif");
	ImageIcon redCannonSelected = new ImageIcon("resources/redCannonSelected.gif");
	ImageIcon yellowCannonSelected = new ImageIcon("resources/yellowCannonSelected.gif");
	ImageIcon blueCannonSelected = new ImageIcon("resources/blueCannonSelected.gif");
	ImageIcon attackerSelected = new ImageIcon("resources/colorInfantry.gif");
	
	public IconHandler(){
		
	}
	
	public ImageIcon getIcon(Player p, int i){
		if(i<5){
			if(p.getColor()==Color.RED){
				return redInfantrie;
			}
			else if(p.getColor()==Color.GREEN){
				return greenInfantrie;
			}
			else if(p.getColor()==Color.YELLOW){
				return yellowInfantrie;
			}
			else if(p.getColor()==Color.BLUE){
				return blueInfantrie;
			}
		}
		else if(i>=5 && i<10){
			if(p.getColor()==Color.RED){
				return redKnight;
			}
			else if(p.getColor()==Color.GREEN){
				return greenKnight;
			}
			else if(p.getColor()==Color.YELLOW){
				return yellowKnight;
			}
			else if(p.getColor()==Color.BLUE){
				return blueKnight;
			}
		}
		else{
			if(p.getColor()==Color.RED){
				return redCannon;
			}
			else if(p.getColor()==Color.GREEN){
				return greenCannon;
			}
			else if(p.getColor()==Color.YELLOW){
				return yellowCannon;
			}
			else if(p.getColor()==Color.BLUE){
				return blueCannon;
			}
		}
		return null;
	}
	
	public ImageIcon getSelectedIcon(Player p, int i){
		if(i<5){
			if(p.getColor()==Color.RED){
				return redInfantrieSelected;
			}
			else if(p.getColor()==Color.GREEN){
				return greenInfantrieSelected;
			}
			else if(p.getColor()==Color.YELLOW){
				return yellowInfantrieSelected;
			}
			else if(p.getColor()==Color.BLUE){
				return blueInfantrieSelected;
			}
		}
		else if(i>=5 && i<10){
			if(p.getColor()==Color.RED){
				return redKnightSelected;
			}
			else if(p.getColor()==Color.GREEN){
				return greenKnightSelected;
			}
			else if(p.getColor()==Color.YELLOW){
				return yellowKnightSelected;
			}
			else if(p.getColor()==Color.BLUE){
				return blueKnightSelected;
			}
		}
		else{
			if(p.getColor()==Color.RED){
				return redCannonSelected;
			}
			else if(p.getColor()==Color.GREEN){
				return greenCannonSelected;
			}
			else if(p.getColor()==Color.YELLOW){
				return yellowCannonSelected;
			}
			else if(p.getColor()==Color.BLUE){
				return blueCannonSelected;
			}
		}
		return null;
	}
}

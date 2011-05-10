package edu.chl.chalmerisk.risk.core;
import java.awt.Color;
import javax.swing.ImageIcon;
import edu.chl.chalmerisk.risk.constants.Player;


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
	ImageIcon compInf = new ImageIcon("resources/greyInfantry.gif");
	
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
}

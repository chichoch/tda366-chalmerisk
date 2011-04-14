package edu.chl.chalmerisk.risk.core;
import edu.chl.chalmerisk.risk.*;

import java.awt.Color;

import javax.swing.ImageIcon;

import edu.chl.chalmerisk.risk.constants.Player;


public class IconHandler {
	ImageIcon redKnight = new ImageIcon("resources/KnightRed.gif");
	ImageIcon greenInfantrie = new ImageIcon("resources/greenInfantry.gif");
	ImageIcon redInfantrie = new ImageIcon("resources/redInfantry.gif");
	ImageIcon greenCannon = new ImageIcon("resources/greenCannon.gif");
	ImageIcon redCannon = new ImageIcon("resources/redCannon.gif");
	ImageIcon greenKnight = new ImageIcon("resources/KnightSmall.gif");
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
		}
		else if(i>=5 && i<10){
			if(p.getColor()==Color.RED){
				return redKnight;
			}
			else if(p.getColor()==Color.GREEN){
				return greenKnight;
			}
		}
		else{
			if(p.getColor()==Color.RED){
				return redCannon;
			}
			else if(p.getColor()==Color.GREEN){
				return greenCannon;
			}
		}
		return null;
	}
}

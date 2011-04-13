package edu.chl.chalmerisk.risk.core;
import edu.chl.chalmerisk.risk.*;

import java.awt.Color;

import javax.swing.ImageIcon;

import edu.chl.chalmerisk.risk.constants.Player;


public class IconHandler {
	ImageIcon redKnight = new ImageIcon("KnightRed.gif");
	ImageIcon greenInfantrie = new ImageIcon("greenInfantry.gif");
	ImageIcon redInfantrie = new ImageIcon("redInfantry.gif");
	ImageIcon greenCannon = new ImageIcon("greenCannon.gif");
	ImageIcon redCannon = new ImageIcon("redCannon.gif");
	ImageIcon greenKnight = new ImageIcon("KnightSmall.gif");
	
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

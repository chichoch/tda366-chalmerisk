package edu.chl.chalmerisk.risk.core;

import java.awt.Color;
import edu.chl.chalmerisk.risk.constants.Map;
import edu.chl.chalmerisk.risk.constants.Player;
import edu.chl.chalmerisk.risk.ctrl.AttackController;
import edu.chl.chalmerisk.risk.ctrl.DiceController;
import edu.chl.chalmerisk.risk.view.AttackDialog;
import edu.chl.chalmerisk.risk.view.GUItest;


public class Builder {
	public static Player player1 = new Player(Color.RED, "Fredrik");
	public static Player player2 = new Player(Color.GREEN, "Christope");
	public static Map map = new Map();
	public static IconHandler iconHandler = new IconHandler();
	public static GUItest guiTest = new GUItest();
	public static AttackDialog attack = new AttackDialog();
	public static AttackController aCtrl = new AttackController();
	public static DiceController diceC = new DiceController();
	public static Turn turn = new Turn();
	public Builder(){
	}
}


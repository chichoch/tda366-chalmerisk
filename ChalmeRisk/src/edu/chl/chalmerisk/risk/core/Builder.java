package edu.chl.chalmerisk.risk.core;

import java.awt.Color;
import edu.chl.chalmerisk.risk.constants.Map;
import edu.chl.chalmerisk.risk.constants.Player;
import edu.chl.chalmerisk.risk.ctrl.*;
import edu.chl.chalmerisk.risk.view.*;



public class Builder {
	public static Player player1 = new Player(Color.RED, "Fredrik");
	public static Player player2 = new Player(Color.GREEN, "Christope");
	public static Map map = new Map();
	public static IconHandler iconHandler = new IconHandler();
	public static GUItest guiTest = new GUItest();
	public static AttackDialog attack = new AttackDialog();
	public static MovementDialog movement = new MovementDialog();
	public static AttackController aCtrl = new AttackController();
	public static ReinforcementController rCtrl = new ReinforcementController();
	public static TroopMovementController tCtrl = new TroopMovementController();
	public static DiceController diceC = new DiceController();
	public static Turn turn = new Turn();
	public Builder(){
	}
}


import java.awt.Color;


public class Builder {
	public static Player player1 = new Player(Color.RED, "Fredrik");
	public static Player player2 = new Player(Color.GREEN, "Christope");
	public static IconHandler iconHandler = new IconHandler();
	public static Map map = new Map();
	public static GUItest guiTest = new GUItest();
	public static AttackDialog attack = new AttackDialog();
	public static AttackController aCtrl = new AttackController();
	
	public Builder(){
	}
}


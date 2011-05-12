package edu.chl.chalmerisk.risk;
import java.io.FileNotFoundException;
import edu.chl.chalmerisk.risk.ctrl.MenuController;
import edu.chl.chalmerisk.risk.view.MenuView;

public class Main {
	
	public static MenuController mCtrl;

	public static void main (String[] arg) throws FileNotFoundException {
		mCtrl = new MenuController();
		new MenuView();

		//bugtest v2
		//new PaintDice();
		//The following code was just for testing:
		/*
		List<Player> list = new ArrayList<Player>();
		Player p1 = new Player(Color.red, "Player1");
		Player p2 = new Player(Color.BLACK, "Player2");
		Player p3 = new Player(Color.red, "Player 3");
		Player p4 = new Player(Color.red, "Player 4");
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		Round round = new Round(list);
		for (int i = 0; i < 10; i++) {
			round.newRound();
		}
		System.out.println("Number of players: " + round.getNumberOfPlayers());
		
		//Remove one player and test again:
		list.remove(2);
		for (int i = 0; i < 10; i++) {
			round.newRound();
		}
		System.out.println("Number of players: " + round.getNumberOfPlayers());
		*/
	}
}

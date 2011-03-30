
public class Main {
	public static void main (String[] arg) {
		new GUItest();
		Country sverige = new Country("Sverige", "Player 1", 12);
		Country danmark = new Country("Danmark", "Player 2", 12);
		new Attack(sverige, danmark);
		
	}
}


public class Main {
	public static void main (String[] arg) {
		new GUItest();
		Country sverige = new Country("Sverige", "Player 1", 16);
		Country danmark = new Country("Danmark", "Player 2", 16);
		new Attack(sverige, danmark);
	}
}

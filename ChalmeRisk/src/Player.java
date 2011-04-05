
public class Player {
	
	public enum Colur{ BLUE, RED, GREEN, YELLOW, BLACK, BROWN}
	public enum Name{ PLAYER1, PLAYER2, PLAYER3, PLAYER4, PLAYER5, PLATER6 }
	
	private final Colur colur;
    private final Name name;
    private Player(Colur colur, Name name) {
        this.name = name;
        this.colur = colur;
    }
}

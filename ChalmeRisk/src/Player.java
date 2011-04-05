
public class Player {
	
	public enum Color{ BLUE, RED, GREEN, YELLOW, BLACK, BROWN}
	private String name;
	
	private final Color color;
    private Player(Color color,String name) {
    	this.name = name;
        this.color = color;
    }
    
    public Color color() {
    	return color;
    }
    
    public String getName() {
    	return name;
    }
}

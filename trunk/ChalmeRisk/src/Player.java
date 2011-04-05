import java.awt.Color;


public class Player {
	
	private Color color;
	private String name;
	
    private Player(Color color,String name) {
    	this.name = name;
        this.color = color;
    }
    
    public Color getColor() {
    	return color;
    }
    
    public String getName() {
    	return name;
    }
    
}

import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;


public class CountryView extends JPanel implements Observer{
	private JLabel troopDisplay;
	private ImageIcon icon;
	private JLabel troopIcon;
	
	public CountryView(Country country){
		setLayout(new FlowLayout());
		icon = new ImageIcon("redCannon.gif");
		troopIcon = new JLabel();
		troopDisplay = new JLabel("14");
		troopIcon.setIcon(icon);
		add(troopIcon);
		add(troopDisplay);
		setPreferredSize(new Dimension(75,75));
	}
	
	@Override
	public void update(Observable Country, Object arg) {
		System.out.println("blah");
	}
}
import java.awt.BorderLayout;
import javax.swing.*;


public class GUItest extends JFrame {
	private JButton leftUpperCountry;
	private JButton rightUpperCountry;
	private JButton leftDownCountry;
	private JButton rightDownCountry;
	
	public GUItest() {
		setLayout(new BorderLayout());
		ImageIcon icon = new ImageIcon("Karta.jpg");
		JLabel l = new JLabel(icon);
		setTitle("ChalmeRisk");
		add(l);
		setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH); //Fullscreen
		setVisible(true);
		pack();
	}
}

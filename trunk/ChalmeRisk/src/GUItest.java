import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;


public class GUItest extends JFrame {
	private JPanel karta;
	private JPanel bottom;
	private JPanel top;
	private JButton leftUpperCountry;
	private JButton rightUpperCountry;
	private JButton leftDownCountry;
	private JButton rightDownCountry;
	private JButton nextStep;
	
	public GUItest() {
		setLayout(new BorderLayout());
		ImageIcon icon = new ImageIcon("Karta.jpg");
		karta = new JPanel();
		karta.setLayout(new FlowLayout());
		leftUpperCountry = new JButton ("Land1");
		leftDownCountry = new JButton ("Land2");
		
		//karta.setOpaque(true);
		//karta.setVisible(false);
		
		//karta.add(l);
		
		bottom = new JPanel();
		//bottom.setVisible(false);
		nextStep = new JButton("Nästa steg");
		bottom.add(nextStep);
		
		top = new JPanel();
		
		JLabel l = new JLabel(icon);
		
		setTitle("ChalmeRisk");
		karta.add(l);
		add(karta, BorderLayout.CENTER);
		karta.add(leftUpperCountry);
		karta.add(leftDownCountry);
		add(bottom, BorderLayout.SOUTH);
		add(top, BorderLayout.NORTH);
		
		
		
		setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH); //Fullscreen
		setVisible(true);
		pack();
	}
	public GUItest(Country a, Country b, Country c, Country d){
	
	}
}

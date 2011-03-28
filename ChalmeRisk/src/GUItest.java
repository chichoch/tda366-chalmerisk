import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;




public class GUItest extends JFrame {
	public GUItest() {
		setLayout(new BorderLayout());
		ImageIcon icon = new ImageIcon("/home/christophe/Hämtningar/riskmap_liten.png");
		JLabel l = new JLabel(icon);
		setTitle("ChalmeRisk");
		add(l);
		setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		pack();
	}
}

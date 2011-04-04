import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class GUItest extends JFrame {
	private JLayeredPane karta;
	private JPanel bottom;
	private JPanel top;
	private JButton norge;
	private JButton danmark;
	private JButton sweden;
	private JButton finland;
	private JButton nextStep;
	Country finland1 = new Country("Finland", "Player 2", 12);
	Country norge1 = new Country("Norge", "Player 2", 12);
	
	public GUItest() {
		setLayout(new BorderLayout());
		ImageIcon icon = new ImageIcon("testmap.gif");
		ImageIcon knightr = new ImageIcon("KnightRed.gif");
		ImageIcon infg = new ImageIcon("greenInfantry.gif");
		ImageIcon infr = new ImageIcon("redInfantry.gif");
		ImageIcon cang = new ImageIcon("greenCannon.gif");
		karta = new JLayeredPane();
		karta.setBackground(Color.BLUE);
		JLabel l = new JLabel(icon);
		norge = new JButton (knightr);
		sweden = new JButton (infg);
		danmark = new JButton (infr);
		finland = new JButton (cang);
		norge.setBounds(560, 225, 75, 75);
		norge.setContentAreaFilled(false);
		norge.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
		sweden.setBounds(800, 300, 75, 75);
		sweden.setContentAreaFilled(false);
		sweden.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
		danmark.setBounds(975, 280, 75, 75);
		danmark.setContentAreaFilled(false);
		danmark.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
		finland.setBounds(530, 350, 75, 75);
		finland.setContentAreaFilled(false);
		finland.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        karta.add(norge, JLayeredPane.DEFAULT_LAYER);
        karta.add(sweden, JLayeredPane.DEFAULT_LAYER);
        karta.add(danmark, JLayeredPane.DEFAULT_LAYER);
        karta.add(finland, JLayeredPane.DEFAULT_LAYER);

        l.setIcon(icon); // NOI18N
        l.setBounds(200, -50, 1000, 800);
        karta.add(l, JLayeredPane.DEFAULT_LAYER);
	
		bottom = new JPanel();
		nextStep = new JButton("Nästa steg");
		bottom.add(nextStep);
		top = new JPanel();
		top.setBackground(Color.BLACK);
		
		
		
		setTitle("ChalmeRisk");
		add(karta, BorderLayout.CENTER);
		add(bottom, BorderLayout.SOUTH);
		add(top, BorderLayout.NORTH);
		
		
		norge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				new Attack(norge1, finland1);
			}
		});
		
		setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH); //Fullscreen
		setVisible(true);
		pack();
	}
}

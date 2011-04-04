import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class GUItest extends JFrame implements ActionListener {
	private JLayeredPane karta;
	private JPanel bottom;
	private JPanel top;
	private JButton norge;
	private JButton danmark;
	private JButton sweden;
	private JButton finland;
	private JButton nextStep;
	public static AttackController aCtrl = new AttackController();
	
	public GUItest() {
		setLayout(new BorderLayout());
		ImageIcon icon = new ImageIcon("testmap.gif");
		ImageIcon knightr = new ImageIcon("KnightRed.gif");
		ImageIcon infg = new ImageIcon("greenInfantry.gif");
		ImageIcon infr = new ImageIcon("redInfantry.gif");
		ImageIcon cang = new ImageIcon("greenCannon.gif");
		karta = new JLayeredPane();
		karta.setBackground(Color.BLUE);
		
		//Set icons
		JLabel l = new JLabel(icon);
		norge = new JButton (knightr);
		sweden = new JButton (infg);
		danmark = new JButton (infr);
		finland = new JButton (cang);
		
		//Set bounds
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
        
        //Add ActionListeners
        norge.addActionListener(this);
        sweden.addActionListener(this);
        danmark.addActionListener(this);
        finland.addActionListener(this);

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
		
		
		
		setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH); //Fullscreen
		setVisible(true);
		pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == norge) {
			aCtrl.setCountry(1);
		}
		if (e.getSource() == sweden) {
			aCtrl.setCountry(2);
		}
		if (e.getSource() == finland) {
			aCtrl.setCountry(3);
		}
		if (e.getSource() == danmark) {
			aCtrl.setCountry(4);
		}
	}
}

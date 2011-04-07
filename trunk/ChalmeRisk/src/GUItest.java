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
	private JButton denmark;
	private JButton sweden;
	private JButton finland;
	private JButton nextStep;
	
	public GUItest() {
		setLayout(new BorderLayout());
		ImageIcon icon = new ImageIcon("testmap1.jpg");
		ImageIcon knightr = new ImageIcon("KnightRed.gif");
		ImageIcon infg = new ImageIcon("greenInfantry.gif");
		ImageIcon infr = new ImageIcon("redInfantry.gif");
		ImageIcon cang = new ImageIcon("greenCannon.gif");
		karta = new JLayeredPane();
		karta.setBackground(Color.BLUE);
		
		//Set icons
		JLabel l = new JLabel(icon);
		//norge = new JButton (Builder.iconHandler.getIcon(Builder.map.getCountry(1).getOwner(), Builder.map.getCountry(1).getTroops()));
		norge = new JButton (Builder.iconHandler.getIcon(Builder.player1, Builder.map.getCountry(1).getTroops()));
		sweden = new JButton (Builder.iconHandler.getIcon(Builder.player2, Builder.map.getCountry(2).getTroops()));
		denmark = new JButton (Builder.iconHandler.getIcon(Builder.player1, Builder.map.getCountry(3).getTroops()));
		finland = new JButton (Builder.iconHandler.getIcon(Builder.player2, Builder.map.getCountry(4).getTroops()));
		
		//Set bounds
		norge.setBounds(600, 235, 75, 75);
		norge.setContentAreaFilled(false);
		norge.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
		sweden.setBounds(755, 310, 75, 75);
		sweden.setContentAreaFilled(false);
		sweden.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
		denmark.setBounds(820, 270, 75, 75);
		denmark.setContentAreaFilled(false);
		denmark.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
		finland.setBounds(630, 330, 75, 75);
		finland.setContentAreaFilled(false);
		finland.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        karta.add(norge, JLayeredPane.DEFAULT_LAYER);
        karta.add(sweden, JLayeredPane.DEFAULT_LAYER);
        karta.add(denmark, JLayeredPane.DEFAULT_LAYER);
        karta.add(finland, JLayeredPane.DEFAULT_LAYER);
        
        //Add ActionListeners
        norge.addActionListener(this);
        sweden.addActionListener(this);
        denmark.addActionListener(this);
        finland.addActionListener(this);

        l.setIcon(icon); // NOI18N
        l.setBounds(0, -50, 1400, 800);
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
			Builder.aCtrl.setCountry(1);
		}
		if (e.getSource() == sweden) {
			Builder.aCtrl.setCountry(2);
		}
		if (e.getSource() == finland) {
			Builder.aCtrl.setCountry(3);
		}
		if (e.getSource() == denmark) {
			Builder.aCtrl.setCountry(4);
		}
	}
}

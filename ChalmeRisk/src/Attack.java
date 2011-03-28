import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Attack extends JFrame{
	
	private ImageIcon icon;
	private ImageIcon icon2;
	private JPanel teamOnePanel;
	private JPanel teamTwoPanel;
	private JPanel actionPanel;
	private JButton exit;
	private JButton attack;
	private JLabel ikon;
	private JLabel ikon2;
	private JLabel ikon3;
	private JLabel ikon4;
	private JLabel ikon5;
	private JLabel ikon6;
	private JLabel ikon7;
	private JLabel ikon8;
	private JLabel winner;
	private JButton invade;
	
	public Attack(){
		init();
	}
	
	private void init(){
		invade = new JButton();
		invade.setVisible(false);
		invade.setEnabled(false);
		
		invade.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	System.exit(0);
            }
		});
		
		icon = new ImageIcon("KnightSmall.gif");
		icon2 = new ImageIcon("KnightRed.gif");
		ikon = new JLabel(icon);
		ikon.setVisible(true);
		ikon2 = new JLabel(icon);
		ikon2.setVisible(true);
		ikon3 = new JLabel(icon);
		ikon3.setVisible(true);
		ikon4 = new JLabel(icon);
		ikon4.setVisible(true);
		ikon5 = new JLabel(icon2);
		ikon5.setVisible(true);
		ikon6 = new JLabel(icon2);
		ikon6.setVisible(true);
		ikon7 = new JLabel(icon2);
		ikon7.setVisible(true);
		ikon8 = new JLabel(icon2);
		ikon8.setVisible(true);
		
		exit = new JButton("Retreat!");
		exit.setVisible(true);
		exit.setSize(50, 25);
		exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	System.exit(0);
            }
		});
		attack = new JButton("Attack!");
		attack.setVisible(true);
		attack.setSize(50, 25);
		
		winner = new JLabel("Start Attacking");

		teamOnePanel = new JPanel();
		teamOnePanel.setVisible(true);
		teamOnePanel.setLayout(new GridLayout(4,1));
		teamOnePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		teamOnePanel.add(ikon);
		teamOnePanel.add(ikon2);
		teamOnePanel.add(ikon3);
		teamOnePanel.add(ikon4);
		
		teamTwoPanel = new JPanel();
		teamTwoPanel.setVisible(true);
		teamTwoPanel.setLayout(new GridLayout(4,1));
		teamTwoPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		teamTwoPanel.add(ikon5);
		teamTwoPanel.add(ikon6);
		teamTwoPanel.add(ikon7);
		teamTwoPanel.add(ikon8);
		
		actionPanel = new JPanel();
		actionPanel.setVisible(true);
		actionPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		actionPanel.setLayout(new FlowLayout());
		actionPanel.add(exit);
		actionPanel.add(attack);
		actionPanel.add(winner);
		actionPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		this.setLayout(new GridLayout(1,3));
		this.add(teamOnePanel);
		this.add(actionPanel);
		this.add(teamTwoPanel);
		
		attack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
            	double i = Math.random()*10;
        		if(i < 5){
        			teamOnePanel.remove(0);
        			winner.setText("Red killed 1");
        		}
        		else if(i>5){
        			teamTwoPanel.remove(0);
        			winner.setText("Green Killed 1");
        		}
        		if(teamOnePanel.getComponentCount()==0){
        			actionPanel.setLayout(new BorderLayout());
        			actionPanel.add(invade);
        			winner.setVisible(false);
        			attack.setEnabled(false);
        			attack.setVisible(false);
        			exit.setVisible(false);
        			exit.setEnabled(false);
        			invade.setText("Flee!");
        			invade.setEnabled(true);
        			invade.setVisible(true);
        		}
        		if(teamTwoPanel.getComponentCount()==0){
        			actionPanel.setLayout(new BorderLayout());
        			actionPanel.add(invade);
        			winner.setVisible(false);
        			attack.setEnabled(false);
        			attack.setVisible(false);
        			exit.setVisible(false);
        			exit.setEnabled(false);
        			invade.setText("Invade!");
        			invade.setVisible(true);
        			invade.setEnabled(true);
        		}
        		
        		repaint();
            }
		});
		setUndecorated(true);
		setVisible(true);
		pack();
		setLocation(450, 200);
		setSize(400, 400);
	}
}


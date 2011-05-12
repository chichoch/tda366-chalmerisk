package edu.chl.chalmerisk.risk.view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.chl.chalmerisk.risk.core.ChalmeRisk;

public class ReinforcementPanel extends JPanel implements Observer{
	private int troops;
	private JLabel troopLabel;
	private JLabel iconLabel;
	private ImageIcon icon;
	
	public ReinforcementPanel(int troops) {
		this.troops = troops;
		icon = ChalmeRisk.iconHandler.getIcon(ChalmeRisk.round.getCurrentPlayer(), 1);
		iconLabel = new JLabel(icon);
		for (int i = 0; i < ChalmeRisk.round.getPlayerList().size(); i++) {
			ChalmeRisk.round.getPlayerList().get(i).addObserver(this);
		}
		troopLabel = new JLabel("" + troops);
		//setBackground(Color.black);
		setOpaque(false);
		add(iconLabel);
		add(troopLabel);
		setPreferredSize(new Dimension(10,30));
		setVisible(true);
	}

	@Override
	public void update(Observable observable, Object arg) {
		if(observable.equals(ChalmeRisk.round.getCurrentPlayer())){
			if(arg.equals(new Integer(0))){
				if (ChalmeRisk.round.getCurrentPlayer().getReinforcements() > 0) {
					iconLabel.setIcon(ChalmeRisk.iconHandler.getIcon(ChalmeRisk.round.getCurrentPlayer(), 1));
					troopLabel.setText("" + ChalmeRisk.round.getCurrentPlayer().getReinforcements());
					iconLabel.setVisible(true);
					validate();
				}
				else {
					troopLabel.setText("");
					iconLabel.setVisible(false);
					validate();
				}
			}
		}
		//TODO This method never runs, which it should. 
		if (observable.equals(ChalmeRisk.turn)) {
			if(arg.equals(new Integer(1))){
				troopLabel.setText("" + ChalmeRisk.round.getCurrentPlayer().getReinforcements());
				System.out.println("NU ÄR DU I UPDATE I REINFORCEMENTPANEL");
				validate();
			}
		}
	}
}

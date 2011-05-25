package edu.chl.chalmerisk.risk.view;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.chl.chalmerisk.risk.core.ChalmeRisk;

/**
 * This Panel shows the Reinforcements you can set out 
 * in the Reinforcement-state. 
 * 
 *
 */
public class ReinforcementPanel extends JPanel implements Observer{
	private int troops;
	private JLabel troopLabel;
	private JLabel iconLabel;
	private ImageIcon icon;
	
	public ReinforcementPanel(int troops) {
		this.troops = troops;
		icon = ViewBuilder.iconHandler.getIcon(ChalmeRisk.round.getCurrentPlayer(), 1);
		iconLabel = new JLabel(icon);
		ChalmeRisk.turnModel.addObserver(this);
		for (int i = 0; i < ChalmeRisk.round.getPlayerList().size(); i++) {
			ChalmeRisk.round.getPlayerList().get(i).addObserver(this);
		}
		troopLabel = new JLabel("" + troops);
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
					iconLabel.setIcon(ViewBuilder.iconHandler.getIcon(ChalmeRisk.round.getCurrentPlayer(), 1));
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
		
		if (observable.equals(ChalmeRisk.turnModel)) {
			if(arg.equals(new Integer(0))){
				iconLabel.setIcon(ViewBuilder.iconHandler.getIcon(ChalmeRisk.round.getCurrentPlayer(), 1));
				troopLabel.setText("" + ChalmeRisk.round.getCurrentPlayer().getReinforcements());
				iconLabel.setVisible(true);
				validate();
			}
		}
	}
}

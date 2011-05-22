package edu.chl.chalmerisk.risk.ctrl;

import java.awt.Color;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import edu.chl.chalmerisk.risk.core.Country;
import edu.chl.chalmerisk.risk.core.Player;


public class TroopMovementControllerTest {
	private TroopMovementController mCtrl;
	private Player player;
	private Country c1;
	private Country c2;
	
	@Before
	public void setUp() {
		mCtrl = new TroopMovementController();
		player = new Player(Color.BLACK, "Player1");
		int[] n = {1, 2};
		c1 = new Country("c1", 1, 100, 100, 10, n, player);
		c2 = new Country("c2", 2, 100, 100, 10, n, player);
	}
	
	@Test
	public void moveTroopsTest() {
		mCtrl.doMovement(5, c1, c2);
		Assert.assertTrue(c1.getTroops() == 5);
		Assert.assertTrue(c2.getTroops() == 15);
	}
}

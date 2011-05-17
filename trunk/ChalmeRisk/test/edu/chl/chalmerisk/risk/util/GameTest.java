package edu.chl.chalmerisk.risk.util;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.chl.chalmerisk.risk.constants.Continent;
import edu.chl.chalmerisk.risk.constants.Country;
import edu.chl.chalmerisk.risk.constants.Player;
import edu.chl.chalmerisk.risk.core.ChalmeRisk;


public class GameTest {
	private List<Player> pList;
	private List<Country> countries;
	private Continent cont1;
	private Continent cont2;
	private Continent cont3;
	static ChalmeRisk risk;
 		
	@Before
	public void setUp() throws FileNotFoundException{
		pList = new ArrayList<Player>();
		pList.add(new Player(Color.RED, "Chris"));
		pList.add(new Player(Color.GREEN, "Fredrik"));
		pList.add(new Player(Color.BLUE, "Alexander"));
		pList.add(new Player(Color.YELLOW, "Joakim"));
		
		risk = new ChalmeRisk(pList, "testmap");

		countries = new ArrayList<Country>();
		//All countries are neighbours.
		int[] g = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		
		Country c1 = new Country("Country1", 1, 100, 100, 1, g, pList.get(0));
		Country c2 = new Country("Country2", 2, 100, 100, 1, g, pList.get(0));
		Country c3 = new Country("Country3", 3, 100, 100, 1, g, pList.get(0));
		Country c4 = new Country("Country4", 4, 100, 100, 1, g, pList.get(0));
		Country c5 = new Country("Country5", 5, 100, 100, 1, g, pList.get(0));
		Country c6 = new Country("Country6", 6, 100, 100, 1, g, pList.get(0));
		Country c7 = new Country("Country7", 7, 100, 100, 1, g, pList.get(0));
		Country c8 = new Country("Country8", 8, 100, 100, 1, g, pList.get(0));
		Country c9 = new Country("Country9", 9, 100, 100, 1, g, pList.get(0));
		Country c10 = new Country("Country10", 10, 100, 100, 1, g, pList.get(0));
		Country c11 = new Country("Country11", 11, 100, 100, 1, g, pList.get(0));
		Country c12 = new Country("Country12", 12, 100, 100, 1, g, pList.get(0));
		Country c13 = new Country("Country13", 13, 100, 100, 1, g, pList.get(0));
		Country c14 = new Country("Country14", 14, 100, 100, 1, g, pList.get(0));
		Country c15 = new Country("Country15", 15, 100, 100, 1, g, pList.get(0));
		
		countries.add(c1);
		countries.add(c2);
		countries.add(c3);
		countries.add(c4);
		countries.add(c5);
		countries.add(c6);
		countries.add(c7);
		countries.add(c8);
		countries.add(c9);
		countries.add(c10);
		countries.add(c11);
		countries.add(c12);
		countries.add(c13);
		countries.add(c14);
		countries.add(c15);
		
		risk.map.setCountries(countries);
		
		//Creates 3 continents with 5 countries in each and value 5:
		List<Country> cont1Countries = new ArrayList<Country>();
		cont1Countries.add(c1);
		cont1Countries.add(c2);
		cont1Countries.add(c3);
		cont1Countries.add(c4);
		cont1Countries.add(c5);
		cont1 = new Continent("Cont1", cont1Countries, 5);
		
		List<Country> cont2Countries = new ArrayList<Country>();
		cont2Countries.add(c6);
		cont2Countries.add(c7);
		cont2Countries.add(c8);
		cont2Countries.add(c9);
		cont2Countries.add(c10);
		cont2 = new Continent("Cont2", cont2Countries, 5);
		
		List<Country> cont3Countries = new ArrayList<Country>();
		cont3Countries.add(c11);
		cont3Countries.add(c12);
		cont3Countries.add(c13);
		cont3Countries.add(c14);
		cont3Countries.add(c15);
		cont3 = new Continent("Cont3", cont3Countries, 5);
		
		List<Continent> continentList = new ArrayList<Continent>();
		continentList.add(cont1);
		continentList.add(cont2);
		continentList.add(cont3);
		
		risk.map.setContinents(continentList);
	}
	
	@Test
	public void TestSetReinforcementsFirstRounds() {
		List<Player> testList = new ArrayList<Player>();
		testList = ReinforcementCalculator.getInstance().setReinforcementsFirstRounds(pList);
		Player p1 = testList.get(0);
		Player p2 = testList.get(1);
		Player p3 = testList.get(2);
		Player p4 = testList.get(3);
		Assert.assertTrue(p1.getReinforcements() == 10);
		Assert.assertTrue(p2.getReinforcements() == 10);
		Assert.assertTrue(p3.getReinforcements() == 10);
		Assert.assertTrue(p4.getReinforcements() == 10);
		
		//Test to remove a player and check if the reinforcement still works.
		testList.remove(0);
		testList = ReinforcementCalculator.getInstance().setReinforcementsFirstRounds(testList);
		Assert.assertTrue(p2.getReinforcements() == 11);
	}
	
	// Tests the ReinforcementMain-method.
	@Test
	public void TestSetReinforcementMain() {
		Player test = pList.get(0);
		test = ReinforcementCalculator.getInstance().setReinforcementsMain(pList.get(0));
		//The reinforcements should be 15/3 + 5*3 = 20. (From the rules for the game). 
		Assert.assertTrue(test.getReinforcements() == 20);
	}
	
}

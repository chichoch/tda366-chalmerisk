package edu.chl.chalmerisk.risk.core;

import java.io.FileNotFoundException;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;


public class MapBuilderTest {
	private MapBuilder map;
	@Before
	public void setUp() throws FileNotFoundException {
		map = new MapBuilder("test/mapbuildertest.txt");
	}
	
	@Test
	public void testMap() {
		Assert.assertTrue(map.getIconFileName().equals("testfile"));
		Assert.assertTrue(map.getContinents().size() == 2);
		Assert.assertTrue(map.getCountries().size() == 4);
		Assert.assertTrue(map.getCountry(1).getName().equals("test1"));
	}
}

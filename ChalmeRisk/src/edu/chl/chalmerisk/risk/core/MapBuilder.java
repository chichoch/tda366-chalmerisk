package edu.chl.chalmerisk.risk.core;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.chl.chalmerisk.risk.io.FileReader;
import edu.chl.chalmerisk.risk.io.IFileReader;

public class MapBuilder {
	private IFileReader file;
	private List<Country> countries = new ArrayList<Country>();
	private List<Continent> continents = new ArrayList<Continent>();
	private String mapIconFileName;
	private String countryName;
	private int countryId;
	private int countryX;
	private int countryY;
	private int[] countryNeighboors;
	private int numOfCountries;
	private int numOfContinents;
	/**
	 * To do a map, you should write the information about the map like this:
	 * Use # to comment in a file. 
	 * Put the Map-file in "maps/*.txt"
	 * 
	 * First row should be the filename of the maps Iconfile.
	 * After that you could start to define your the continents.
	 * Use the command <continent> and then on the name and its value.
	 * 
	 * Then you should define which countries that is a part of that continent. The countries
	 * should be written like this:
	 * ____________________________________
	 * Name of the Country
	 * The Country's ID
	 * Position, X-axis
	 * Position, Y-axis
	 * Neighbours (Other Country-ID's, seperated with a blank step.
	 * ____________________________________
	 * 
	 * 
	 * 
	 * Heres a example how a map could looke like:
	 * 
	 * Testmap.txt
	___________________________________________________________
	resources/testmap1.jpg

	<continent>
	Skandinavien
	5
	
	<country>
	Norge
	1
	600
	235
	2 3
	
	<country>
	Sverige
	2
	755
	310
	1 3 4
	
	<country>
	Finland
	3
	630
	330
	1 2
	
	<continent>
	Europa
	3
	
	<country>
	Danmark
	4
	820
	270
	2
	___________________________________________________________
	 * 
	 * 
	 *
	 * @throws FileNotFoundException
	 * @author Christophe
	 */
	public MapBuilder(String fileName) throws FileNotFoundException {
		file = FileReader.getInstance();
		List<String> command = file.getFile(fileName);
		mapIconFileName = command.get(0);
		for (int index = 0; index < command.size(); index++) {
			if (command.get(index).equals("<continent>")) {
				String continentName = command.get(index + 1);
				int continentValue = Integer.parseInt(command.get(index + 2));
				List<Country> continentCountries = new ArrayList<Country>();
				int i = index + 1;
				while (!command.get(index + 1).equals("<continent>") && i < command.size()) {
					if (command.get(i).equals("<country>")) {
						countryName = command.get(i + 1);
						countryId = Integer.parseInt(command.get(i + 2));
						countryX = Integer.parseInt(command.get(i + 3));
						countryY = Integer.parseInt(command.get(i + 4));
						
						Scanner sc = new Scanner(command.get(i + 5));
						int numOfNeighbours = 0;
						while (sc.hasNextInt()) {
							numOfNeighbours++;
							sc.nextInt();
						}
						countryNeighboors = new int[numOfNeighbours];
						sc.close();
						Scanner sca = new Scanner(command.get(i + 5));
						for (int j = 0; j < countryNeighboors.length; j++) {
							countryNeighboors[j] = sca.nextInt();
						}
						sca.close();
						Player p = new Player(Color.black, "Random PLayer");
						//Creates a new Country with a standard number of troops (1), and a "Random Player"
						Country c = new Country(countryName, countryId, countryX, countryY, 1, countryNeighboors, p);
						countries.add(c);
						continentCountries.add(c);
						numOfCountries++;
					}
					else if (command.get(i).equals("<continent>")) {
						break;
					}
					i++;
				}
				Continent con = new Continent(continentName, continentCountries, continentValue);
				continents.add(con);
				numOfContinents++;
			}
		}
		
	}
	
 	
 	public List<Country> getCountries() {
 		return countries;
 	}
 	
 	public List<Continent> getContinents() {
 		return continents;
 	}
 	
 	public Country getCountry(int id) {
 		for (int i = 0; i < countries.size(); i++) {
 			if (countries.get(i).getCountryId() == id) {
 				return countries.get(i);
 			}
 		}
 		return null;
 	}
 	
 	public String getIconFileName() {
 		return mapIconFileName;
 	}
 	
 	
	
}

package edu.chl.chalmerisk.risk.io;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.chl.chalmerisk.risk.constants.Country;
import edu.chl.chalmerisk.risk.constants.Player;

public class MapBuilder {
	private IFileReader file;
	private List<Country> countries = new ArrayList<Country>();
	private String mapIconFileName;
	private String countryName;
	private int countryId;
	private int countryX;
	private int countryY;
	private int[] countryNeighboors;
	private int numOfCountries;
	/**
	 * To do a map, you should write the information about the map like this:
	 * Use # to comment in a file. 
	 * Put the Map-file in "maps/*.txt"
	 * 
	 * First row should be the filename of the maps Iconfile.
	 * After that you could start to define your countries like this:
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
	 * ___________________________________________________________
	 * testmap1.jpg
	 * Sverige
	 * 1
	 * 340
	 * 210
	 * 2 4 5 12
	 * 
	 * Norge
	 * 2
	 * 120
	 * 234
	 * 1 5 7
	 * 
	 * Finland
	 * 3
	 * 412
	 * 231
	 * 12 32
	 * ___________________________________________________________
	 * 
	 * 
	 *
	 * @throws FileNotFoundException
	 * @author Christophe
	 */
	
 	public MapBuilder(String fileName) throws FileNotFoundException { 		
		
 		file = FileReader.getInstance();
		List<String> command = file.getFile(fileName);
		numOfCountries = (command.size() - 1) /5;
		mapIconFileName = command.get(0);
		
		for (int i = 0; i < numOfCountries; i++) {
			countryName = command.get((i * 5) + 1);
			System.out.println(countryName);
			countryId = Integer.parseInt(command.get((i * 5) + 2));
			System.out.println("" + countryId);
			countryX = Integer.parseInt(command.get((i * 5) + 3));
			countryY = Integer.parseInt(command.get((i * 5) + 4));
			
			Scanner sc = new Scanner(command.get((i * 5) + 5));
			int numOfNeighbours = 0;
			while (sc.hasNextInt()) {
				numOfNeighbours++;
				sc.nextInt();
			}
			countryNeighboors = new int[numOfNeighbours];
			sc.close();
			Scanner sca = new Scanner(command.get((i * 5) + 5));
			for (int j = 0; j < countryNeighboors.length; j++) {
				countryNeighboors[j] = sca.nextInt();
				
			}
			Player p = new Player(Color.black, "Random PLayer");
			//Creates a new Country with a standard number of troops (1), and a "Random Player"
			Country c = new Country(countryName, countryId, countryX, countryY, 1, countryNeighboors, p);
			countries.add(c);
		}
		System.out.println("Antal l�nder: " + numOfCountries);
	}
 	
 	public List<Country> getCountries() {
 		return countries;
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
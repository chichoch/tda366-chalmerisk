package edu.chl.chalmerisk.risk.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader implements IFileReader {
	private List<String> sList = new ArrayList();
	public List<String> getFile(String filename) throws FileNotFoundException {
		sList.clear();
		Scanner sc = new Scanner(new FileInputStream(filename));
		
		try {
			while (sc.hasNextLine()) {
				String s = sc.nextLine().trim();
				if (s.length() == 0) {
					// Skip empty lines
				} else if (s.matches("#.*")) {
					// Skip comments in file
				} else {
					sList.add(s);
				}
			}
		} finally {
			sc.close();
		}
		return sList;
	}
	
	private FileReader() {
		
	}
	
	public static IFileReader getInstance() {
		return new FileReader();
	}
	
}

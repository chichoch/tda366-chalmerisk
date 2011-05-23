package edu.chl.chalmerisk.risk;
import java.io.FileNotFoundException;

import edu.chl.chalmerisk.risk.view.MenuView;
/**
 * The entrypoint for the application. 
 * Starts the Menu.
 */
public class Main {

	public static void main (String[] arg) throws FileNotFoundException {
		new MenuView();
	}
}

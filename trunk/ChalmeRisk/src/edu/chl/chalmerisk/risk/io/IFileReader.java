package edu.chl.chalmerisk.risk.io;

import java.io.FileNotFoundException;
import java.util.List;
/**
 * Interface for subsystem FileReader 
 * @author hajo, Modified by Christophe.
 *
 */
public interface IFileReader {
	public List<String> getFile(String filename) throws FileNotFoundException;
}

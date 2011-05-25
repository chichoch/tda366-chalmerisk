package edu.chl.chalmerisk.risk.io;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;


public class FileReaderTest {
	
	private IFileReader filereader;
	
	@Before
	public void setUp() {
		filereader = FileReader.getInstance();
	}
	
	/**Test if we can get a List of Strings, and also if we can comment in the files.
	 * We also checks if we can use empty lines.
	 *	
	 * The testfile looks like this:
	 * _________________________________
	 * 	test1
		#Commented line.
		
		test2
		test3
		test4
	 */
	@Test
	public void FileReaderTest() throws FileNotFoundException {
		List<String> list;
		list = filereader.getFile("test/test.txt");
		
		Assert.assertTrue(list.size() == 4);
		Assert.assertTrue(list.get(0).equals("test1"));
		Assert.assertTrue(list.get(1).equals("test2"));
		Assert.assertTrue(list.get(2).equals("test3"));
		Assert.assertTrue(list.get(3).equals("test4"));



	}
}

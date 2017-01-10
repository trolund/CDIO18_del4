package tests;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import model.Dicecup;

public class FakeDicecup extends Dicecup {
	
	private Scanner inputfile;                           // input file
	private String filename = "testdata.txt";            // name of data file
	
	public FakeDicecup(){
		try {
			inputfile = new Scanner(new File(filename)); // open file
		}
		catch (IOException e) {                          // error message if the file cannot be opened
            System.out.println("Cannot read file " + filename + " in " + System.getProperty("user.dir"));
        }
		
		inputfile.close();
	}
	
	// replaces the method with the same name in Raflebaeger
	@Override
	public int getSum(){
		return TestData.getDice();
	}
}

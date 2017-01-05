package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.Gamecontroller;
import model.fields.Chance;
import view.FakeOutput;
import view.Out;

public class ChanceTest {

		Out out= new FakeOutput(); 		// sikre vi kommer uden om GUI
		Gamecontroller gc = new Gamecontroller(out); 


	@Test
	public void testShuffel() {	
		Chance.printCards();
		Chance.shuffleArray();
		Chance.printCards();
		Chance.shuffleArray();
		Chance.printCards();
	}

}

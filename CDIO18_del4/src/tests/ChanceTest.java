package tests;

import static org.junit.Assert.*;


import org.junit.Test;

import controller.Gamecontroller;
import model.Player;
import model.fields.Chance;
import view.FakeOutput;
import view.Out;

public class ChanceTest {

		Out out= new FakeOutput(); 		// sikre vi kommer uden om GUI
		Gamecontroller gc = new Gamecontroller(out); 
		Player p = new Player("Kim",30000);


	@Test
	public void testShuffel() {	
		Chance.printCards();
		Chance.shuffleArray();
		Chance.printCards();
		Chance.shuffleArray();
		Chance.printCards();
	}

	
	@Test
	public void testMove() {	
		System.out.println(p.getPlayerPos());
		
		Chance.getCards()[0].doCard(p); //kort 0 rykker to pladser 
		System.out.println(p.getPlayerPos());
		
		for (int i = 0; i < 21; i++) {
			Chance.getCards()[0].doCard(p); //kort 0 rykker to pladser 
			System.out.println(p.getPlayerPos());
		}
		
	}
}

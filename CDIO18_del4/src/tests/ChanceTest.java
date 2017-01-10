package tests;

import org.junit.Test;

import controller.Gamecontroller;
import model.Player;
import model.cards.Deck;
import view.FakeOutput;
import view.Out;

public class ChanceTest {

		Out out = new FakeOutput(); 		// sikre vi kommer uden om GUI
		Gamecontroller gc = new Gamecontroller(out); 
		Player p = new Player("Kim");


	@Test
	public void testShuffel() {	
		Deck.printCards();
		Deck.shuffleArray();
		Deck.printCards();
		Deck.shuffleArray();
		Deck.printCards();
	}

	
	@Test
	public void testMove() {	
		System.out.println(p.getPlayerPos());
		
		for (int i = 0; i < 21; i++) {
			Deck.getCards()[0].doCard(p, out); //kort 0 rykker to pladser 
			System.out.println(p.getPlayerPos());
		}
		
	}
}

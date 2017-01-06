package model.cards;

import java.util.Random;

public class Deck {

	public static int cardCount = 0;
	public static Card[] cards;
	
	static {
		cards = new Card[]{
			new MoveCard("Ryk to felter", 2, false),
			new BalanceCard("du får 100kr", 100),
			new FreeJailCard("du kan komme ud fra fægsel eller gemme kortet."),
			new MoveCard ("ryk til felt 5", 5, true)
		};
		shuffleArray();
	}

	public static void shuffleArray(){		
		Random rnd = new Random();
		for (int i = cards.length - 1; i > 0; i--)
		{
			int index = rnd.nextInt(i + 1);
			// Simple swap
			Card a = cards[index];
			cards[index] = cards[i];
			cards[i] = a;
		}

	}

}

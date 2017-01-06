package model.fields;

import java.util.Arrays;
import java.util.Random;

import model.Player;
import model.cards.Deck;
import view.Out;

public class Chance extends Field
{
	

	public Chance(String name, String description, Out out)
	{
		super(name, description, out);
	}
	
	public void landOn(Player p, Out o)
	{
		Deck.cards[Deck.cardCount].doCard(p); // tag kort i bunken.
//		Deck.cardCount++; // gør næste kort klar.
		Deck.cardCount = ++Deck.cardCount % Deck.cards.length;
	}
	
	public static void printCards(){
		System.out.println(Arrays.toString(Deck.cards));
	}

	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	


	
	
	
}

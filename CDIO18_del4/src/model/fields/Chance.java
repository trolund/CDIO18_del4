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
		
		
		Deck.cards[Deck.getCardCount()].doCard(p , out); // tag kort i bunken.
//		Deck.cardCount++; // gør næste kort klar.
//		Deck.setCardCount(++Deck % Deck.cards.length);
	}

	@Override
	public int getValue() {
		
		return 0;
	}

	
	
	


	
	
	
}

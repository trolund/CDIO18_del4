package model.fields;

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
		Deck.getCards()[Deck.getCardCount()].doCard(p); // tag kort i bunken.
		Deck.setCardCount((1+Deck.getCardCount()) % Deck.getCards().length);
	}

	@Override
	public int getValue() {
		
		return 0;
	}

	
	
	


	
	
	
}

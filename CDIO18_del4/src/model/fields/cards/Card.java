package model.fields.cards;

import model.Player;

public abstract class Card  {
	
	String description;	
	
	public Card(String description) {
		this.description = description;
	}

	public abstract void doCard(Player p);
}

package model.cards;

import model.Player;

public abstract class Card  {
	
	String description;	
	
	public Card(String description) {
		this.description = description;
	}

	public abstract void doCard(Player p);

	@Override
	public String toString() {
		return description;
	}
	
	
}

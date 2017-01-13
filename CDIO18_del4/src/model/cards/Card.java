package model.cards;

import model.Player;
import view.Out;

public abstract class Card  {
	
	protected String description;
	protected Out out;
	
	
	public Card(String description, Out out) {
		this.description = description;
		this.out = out;
	}

	public abstract void doCard(Player p);

	@Override
	public String toString() {
		return description;
	}
	
	
}

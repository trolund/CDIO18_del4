package model.cards;

import model.Player;
import view.Out;

public class FreeJailCard extends Card {
	
	private Player owner;
	
	public FreeJailCard(String des, Out out) {
		super(des, out);
		this.out = out;
	} 
	
	public void doCard(Player p){
		out.CardsOut(description);
		setOwner(p);
		p.getJailcards().add(this);
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	

	
}

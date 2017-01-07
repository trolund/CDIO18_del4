package model.cards;

import model.Player;
import view.Out;

public class FreeJailCard extends Card {
	
	private Player owner;
	private boolean used = false;
	
	public FreeJailCard(String des, Out out) {
		super(des, out);
		this.out = out;
	}
	
	public void doCard(Player p, Out out){
		out.CardsOut(description);
		setOwner(p);
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	

	
}

package model.cards;

import model.Player;

public class FreeJailCard extends Card {
	
	private Player owner;
	private boolean used = false;
	
	public FreeJailCard(String des) {
		super(des);
	}
	
	public void doCard(Player p){
		setOwner(p);
		
		
		used = true;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}
	

	
}

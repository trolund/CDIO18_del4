package model.fields.cards;

import model.Player;

public class MoveCard extends Card {

	private int move;
	
	public MoveCard(String description, int moves) {
		super(description);
		this.move = moves;
		
	}
	
	public void doCard(Player p){
		
	}

}

package model.fields.cards;

import controller.Gamecontroller;
import model.Player;
import model.fields.Fieldlist;

public class MoveCard extends Card {

	private int move;
	private boolean teleport;	//teleport or move care
	
	public MoveCard(String description, int moves, boolean teleport) {
		super(description);
		this.move = moves;
		this.teleport = teleport;
		
	}
	
	public void doCard(Player p){
		if(teleport){
			if(move == 24 && p.getPlayerPos() > 24){
				p.getAccount().addSum(200);
			}
			p.setPlayerPos(move);
		}
		else{
			moveCarPos(move, p);
		}	
	}
}

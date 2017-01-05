package model.fields.cards;

import controller.Gamecontroller;
import model.Player;

public class MoveCard extends Card {

	private int move;
	
	public MoveCard(String description, int moves) {
		super(description);
		this.move = moves;
		
	}
	
	public void doCard(Player p){
		moveCarPos(move, p);
	}

	
	public void moveCarPos(int amountOfMoves, Player player) 
	{
		if(player.getPlayerPos() + amountOfMoves > Gamecontroller.getList().getFields().length) {
			player.setPlayerPos((player.getPlayerPos() + amountOfMoves) - Gamecontroller.getList().getFields().length);
			player.getAccount().addSum(4000);
		}
		else
		{
			player.setPlayerPos(amountOfMoves + player.getPlayerPos());
		}
	}
}

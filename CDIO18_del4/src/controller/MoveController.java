package controller;

import model.Player;
import model.fields.Fieldlist;

public class MoveController {

	
	public void movePlayer(int amountOfMoves, Player player) 
	{
		if((player.getPlayerPos() + amountOfMoves) >= Fieldlist.getFields().length) {
			
			player.setPlayerPos((player.getPlayerPos() + amountOfMoves) - Fieldlist.getFields().length);
			player.getAccount().addSum(200);
		}
		else
		{
			player.setPlayerPos(amountOfMoves + player.getPlayerPos());
		}
	}
}
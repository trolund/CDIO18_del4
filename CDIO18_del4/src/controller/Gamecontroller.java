package controller;

import model.fields.Fieldlist;
import model.Player;

/*
 * Team 18 - CDIO 3   
 * DTU
 * Collaborators:  KasperLeiszner, Bijan Negari, Helene Zgaya, Frederik von Scholten and Troels Lund
 * 
 *							   ___                               _  ___  
 *							  / _ \_ __ _   _ _ __  _ __   ___  / |( _ ) 
 *							 / /_\/ '__| | | | '_ \| '_ \ / _ \ | |/ _ \ 
 *							/ /_\\| |  | |_| | |_) | |_) |  __/ | | (_) |
 *							\____/|_|   \__,_| .__/| .__/ \___| |_|\___/ 
 *							                 |_|   |_|                   
 * 
 * 
 */

public class Gamecontroller 
{
	
	Fieldlist fdlist = new Fieldlist();

	
	public static void main(String[] args)
	{
		Gamecontroller gm = new Gamecontroller(); 
		Player player = new Player("Kasper");
		
		gm.landOn(player, 6);
	}
	
	public void moveCarPos(int amountOfMoves, Player player) 
	{
		if(player.getPlayerPos() + amountOfMoves > fdlist.getFields().length)
		{
			player.setPlayerPos((player.getPlayerPos() + amountOfMoves) - fdlist.getFields().length);
		}
		else
		{
			player.setPlayerPos(amountOfMoves + player.getPlayerPos());
		}
	}
	
	public void landOn(Player player, int fieldNumber)
	{
		fdlist.getFields()[fieldNumber].landOn(player);
	}
	
}


package controller;

import model.fields.Fieldlist;
import tests.FakeDicecup;
import view.Output;
import model.Dicecup;
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

//numberOfPlayers = out.howManyPlayers();
//players = out.addplayers(players, startSum);

public class Gamecontroller 
{

	private Player[] players;
	private Dicecup cup;
	private Fieldlist list;
	private final int startSum = 30000;
	private static int numberOfPlayers = 0;
	private boolean testMode = false;
	private boolean gameEnded = false;
	private Output out;
	
	public static void main(String[] args)
	{
		Gamecontroller gm = new Gamecontroller(); 
	}
	
	public Gamecontroller(){
		this(new Output());
		out.drawGameboard(list);
	}
	
	public Gamecontroller(Output o){
		out = o;
		list = new Fieldlist(out);
		out.drawGameboard(list);
		testMode = out.setTestMode(); 	// Giver spilleren mulighed for at gå i test mode og tildeler til testMode boolean
	}

	public void moveCarPos(int amountOfMoves, Player player) 
	{
		if(player.getPlayerPos() + amountOfMoves > list.getFields().length) {
			player.setPlayerPos((player.getPlayerPos() + amountOfMoves) - list.getFields().length);
			player.getAccount().addSum(4000);
		}
		else
		{
			player.setPlayerPos(amountOfMoves + player.getPlayerPos());
		}
	}
	

	public static int getNumberOfPlayers() 
	{
		return numberOfPlayers;
	}

}


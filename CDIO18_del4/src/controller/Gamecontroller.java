package controller;

import model.fields.Fieldlist;
import tests.FakeDicecup;
import view.Out;
import view.Output;
import model.Dicecup;
import model.Player;

import desktop_resources.GUI;
import model.Dicecup;
import model.Player;
import model.fields.Fieldlist;
import view.Language;
import view.Output;

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
// out.drawGameboard(list);

public class Gamecontroller 
{

	private Player[] players;
	private Dicecup cup;
	private static Fieldlist list;
	private static int numberOfPlayers = 0;
	private boolean testMode = false;
	private Out out;
	
	public static void main(String[] args)
	{
		Gamecontroller gm = new Gamecontroller(); 
	}
	
	public Gamecontroller(){
		this(new Output());
	}
	
	public Gamecontroller(Out o){
		out = o;
		list = new Fieldlist(out);
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

	public static Fieldlist getList() {
		return list;
	}
	
	

}


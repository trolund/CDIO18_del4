package controller;

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

/*
 * Class wrote by: Troels Lund and Kasper Leiszner
 */

public class Gamecontroller {
	private Player[] player;
	private Dicecup cup = new Dicecup();
	private Output out = new Output();
	private Fieldlist fieldlist = new Fieldlist(out);


	public static void main(String[] args) {
		new Gamecontroller().setup();
	}

	public void setup(){
		player = addPlayer();
		runGame();
	}

	public void runGame(){
		while(true){
			for( int i = 0 ; i < player.length ; i++ ){
				Player p = player[i];
				turn(p);

			}
		}
	}

	public void turn(Player p){
		cup.roll();
		int amountOfMoves = cup.getSum();
		movePlayer(p, amountOfMoves);

		//land på felt



	}


	public void movePlayer(Player p, int amountOfMoves){

		if(p.getPlayerPos() + amountOfMoves > fieldlist.getFields().length){
			p.setPlayerPos((p.getPlayerPos() + amountOfMoves)-fieldlist.getFields().length);
			p.getAccount().setSum(4000);
		}
		else{
			p.setPlayerPos(p.getPlayerPos() + amountOfMoves);
		}
	}

	public Player[] addPlayer(){

		Player[] player = new Player[out.howManyPlayers()];

		for( int i = 0 ; i < player.length ; i++ ){

			String name = GUI.getUserString(Language.getNameOfPlayer() + " " + (i + 1)); //input navn fra GUI(skal laves i Output)
			player[i] = new Player(name, 30000);
			player[i].setPlayerPos(0);
			//			GUI.addPlayer(name, player[i].getAccount().getSum());
			//			GUI.setCar(1, name);
		}

		return player;
	}

	public void winner(){
		int playersAlive = 0;
		for (int i = 0; i < player.length; i++) {
			Player p = player[i];
			boolean bankrupt = p.getBankruptStatus();
			if(!bankrupt) playersAlive++;
		}
		if(playersAlive == 1){
			for (int i = 0; i < player.length; i++) {
				Player p = player[i];
				boolean bankrupt = p.getBankruptStatus();
				if(!bankrupt) {
					out.winnerPrint(p);
					try { Thread.sleep(4000); } catch (InterruptedException e) { }
					GUI.close();
				}
			}
		}
	}
}



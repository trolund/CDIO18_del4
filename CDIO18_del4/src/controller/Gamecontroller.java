package controller;

import desktop_resources.GUI;
import model.Dicecup;
import model.Player;
import model.fields.Fieldlist;
import view.Language;
import view.Out;
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
	private Out out;
	private Fieldlist fieldlist;


	public static void main(String[] args) {
		new Gamecontroller().setup(); //Opretter objekt af gamecontroller og kalder setup
	}

	public Gamecontroller(){
		this(new Output()); //Kalder kontruktøren nedenunder. 
	}
	
	public Gamecontroller(Out out) //Ved test bruges kun denne konstruktør og ikke den ovenstående.
	{
		this.out = out; //
		fieldlist = new Fieldlist(out);
	}
	
	public void setup(){ // Sætter spillet op, opretter spillere
		player = addPlayer(); 
		runGame(); 
	}

	public void runGame(){ // Kører spil med turskift
		while(true){
			for( int i = 0 ; i < player.length ; i++ ){
				Player p = player[i];
				turn(p);

			}
		}
	}

	public void turn(Player p){ //kører en tur for den aktuelle spiller
		cup.roll();
		int amountOfMoves = cup.getSum();
		movePlayer(p, amountOfMoves);
		fieldlist.getFields()[p.getPlayerPos()].landOn(p, out); // Kalder landOn for spillerens position i feltlistens array
		winner(); 

		//kommunikere med gui mangler



	}


	public void movePlayer(Player p, int amountOfMoves){

		if(p.getPlayerPos() + amountOfMoves > fieldlist.getFields().length){
			p.setPlayerPos((p.getPlayerPos() + amountOfMoves)-fieldlist.getFields().length); //Hvis antal ryk og spillerens position overskrider feltlistens længde, trækkes den fra
			p.getAccount().setSum(4000); //Start bonus
		}
		else{
			p.setPlayerPos(p.getPlayerPos() + amountOfMoves);
		}
	}

	public Player[] addPlayer(){

		Player[] player = new Player[out.howManyPlayers()]; // Opretter antal spillere fra input i GUI

		for( int i = 0 ; i < player.length ; i++ ){ 

			String name = GUI.getUserString(Language.getNameOfPlayer() + " " + (i + 1)); //input navn fra GUI(skal laves i Output)
			player[i] = new Player(name, 30000);
			player[i].setPlayerPos(0);
			//			GUI.addPlayer(name, player[i].getAccount().getSum());
			//			GUI.setCar(1, name);
		}

		return player; //
	}

	public void winner(){
		int playersAlive = 0;
		for (int i = 0; i < player.length; i++) { 
			Player p = player[i];
			boolean bankrupt = p.getBankruptStatus(); // Tjekker om spillere er bankrupt
			if(!bankrupt) playersAlive++; //lægger en til hver gang spilleren ikke er bankrupt
		}
		if(playersAlive == 1){ 
			for (int i = 0; i < player.length; i++) { // Tjekker HVILKEN spiller der er tilbage
				Player p = player[i];
				boolean bankrupt = p.getBankruptStatus();
				if(!bankrupt) {
					out.winnerPrint(p);
					try { Thread.sleep(4000); } catch (InterruptedException e) { } //Prøver at holde pause i 4 sekunder efter vinder er fundet. Ellers laver den exception så programmet ikke crasher
					GUI.close();
				}
			}
		}
	}
}



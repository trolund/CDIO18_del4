package controller;

import desktop_resources.GUI;
import model.Dicecup;
import model.Player;
import model.fields.Fieldlist;
import model.fields.Ownabel;
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
	private boolean endGame;

	public static void main(String[] args) 
	{
		new Gamecontroller().setup(); //Opretter objekt af gamecontroller og kalder setup
	}

	public Gamecontroller(){
		this(new Output()); //Kalder kontruktøren nedenunder. 
	}

	public Gamecontroller(Out out) //Ved test bruges kun denne konstruktør og ikke den ovenstående.
	{
		this.out = out; //
		new Fieldlist(out);
	}

	public void setup(){ // Sætter spillet op, opretter spillere
		player = addPlayer(); 
		runGame(); 
	}

	public void runGame(){ // Kører spil med turskift
		while(!endGame){
			for( int i = 0 ; i < player.length ; i++ ){
				Player p = player[i];
				if(!p.getBankruptStatus())
				{
					turn(p);
				}
			}
		}
	}

	public void turn(Player p){ //kører en tur for den aktuelle spiller
		out.rollDiceText();
		cup.roll();
		int amountOfMoves = cup.getSum();
		out.setGUIDice(cup.getDie1().getValue(), cup.getDie2().getValue());
		movePlayer(p, amountOfMoves);
		out.setcar(p);
		out.landMSG(p);
		Fieldlist.getFields()[p.getPlayerPos()].landOn(p, out); // Kalder landOn for spillerens position i feltlistens array
		goBankrupt(p);
		winner(); 

	}

	public void movePlayer(Player p, int amountOfMoves){

		if(p.getPlayerPos() + amountOfMoves > Fieldlist.getFields().length){

			p.setPlayerPos((p.getPlayerPos() + amountOfMoves)-Fieldlist.getFields().length); //Hvis antal ryk og spillerens position overskrider feltlistens længde, trækkes den fra
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
			out.addPlayersToGUI(player[i]);
		}

		return player; //
	}

	public void resetOwnedFields(Player p)
	{
		if(p.getBankruptStatus()) 
		{
			for(int i = 0; i < Fieldlist.getFields().length;i++)
			{
				if(Fieldlist.getFields()[i] instanceof Ownabel)
				{
					if( ((Ownabel) Fieldlist.getFields()[i]).getOwner() == p )
					{
						((Ownabel) Fieldlist.getFields()[i]).setOwner(null);
						out.removeOwner(p.getPlayerPos());
					}
				}
			}
		}
	}

	public void goBankrupt(Player p){

		if(p.getAccount().getSum() <= 0){
			p.setBankrupt(true);
			resetOwnedFields(p);
			GUI.removeCar(p.getPlayerPos(), p.getName());
		}
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
					endGame = true;

				}
			}
		}
	}
}



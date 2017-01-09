package controller;

import desktop_resources.GUI;
import model.Dicecup;
import model.Player;
import model.cards.Deck;
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

public class Gamecontroller 
{
	private Player[] player;
	private Dicecup cup = new Dicecup();
	private Out out;
	private boolean endGame;
	private MoveController movecontroller = new MoveController();

	public static void main(String[] args) 
	{
		new Gamecontroller().setup(); //Opretter objekt af gamecontroller og kalder setup
	}

	public Gamecontroller()
	{
		this(new Output()); //Kalder kontruktøren nedenunder. 
	}

	public Gamecontroller(Out out) //Ved test bruges kun denne konstruktør og ikke den ovenstående.
	{
		this.out = out; //
		new Fieldlist(out);
		new Deck(out);
	}

	public void setup(){ // Sætter spillet op, opretter spillere
		player = addPlayer(); 
		runGame(); 
	}

	public void runGame()
	{ // Kører spil med turskift
		while(!endGame)
		{
			for( int i = 0 ; i < player.length ; i++ )
			{
				Player p = player[i];

				if(!p.getBankruptStatus())
				{
					out.msgGUI(Language.whoseTurn(p));
					turn(p);
				}
			}
		}
	}

	public void turn(Player p)
	{ //kører en tur for den aktuelle spiller



		if(p.isJailed()){
			prisonAction(p);

		}
		else{
			out.rollDiceText();
			cup.roll();

			int amountOfMoves = cup.getSum();

			out.setGUIDice(cup.getDie1().getValue(), cup.getDie2().getValue());

			out.removeCar(p);
			movecontroller.movePlayer(amountOfMoves, p);
			out.setcar(p);
			out.landMSG(p);

			Fieldlist.getFields()[p.getPlayerPos()].landOn(p, out); // Kalder landOn for spillerens position i feltlistens array

			out.setGUIBalance(p);

			goBankrupt(p);
			winner(); 

			if(cup.getDie1().getValue() == cup.getDie2().getValue()){

				out.msgGUI(Language.extraTurn(p));

				turn(p);
			}
		}	
	}

	public void prisonAction(Player p){ // metode til at håndtere vis man er i fængsel 

		String[] option;

		String a = "Køb dig fri for 50kr";
		String b = "Slå dig fri";
		String c = "Brug dit chancekort";

		if(!(p.getJailcards().isEmpty())){ // Hvis du har et jail-card, får du tre mulige menuer:
			option = new String[3];
			option[0] = a;
			option[1] = b;
			option[2] = c;
		}
		else{
			option = new String[2]; 
			option[0] = a;
			option[1] = b;
		}

		switch (out.Jailaction(p, option)){ // hvad skal der ske når man vægler en af de tre mulighder?:
		case "Køb dig fri for 50kr": 
			p.getAccount().withdraw(50);
			p.setJailed(false);
			turn(p);
			
			break;
			
		case "Slå dig fri": 
			out.msgGUI("Slå to ens for at komme fri!");
			out.rollDiceText();
			cup.roll();
			out.setGUIDice(cup.getDie1().getValue(), cup.getDie2().getValue());
			if(cup.getDie1().getValue() == cup.getDie2().getValue()){
				p.setJailed(false);
				turn(p);	// hvis en spiller slår 2 ens, får han sin tur igen, så rykker han fra fængelsfeltet, og kan købe grunde som normalt.
			}
			break;
			
		case "Brug dit chancekort":
			p.setJailed(false);
			p.getJailcards().remove(0).setOwner(null);

			turn(p);		// hvis en spiller bruger jail-card, får han sin tur igen, så rykker han fra fængelsfeltet, og kan købe grunde som normalt.
			break;
		}
	}

	//	public void movePlayer(Player p, int amountOfMoves)
	//	{
	//		if(p.getPlayerPos() + amountOfMoves > Fieldlist.getFields().length)
	//		{
	//			p.setPlayerPos((p.getPlayerPos() + amountOfMoves)-Fieldlist.getFields().length); //Hvis antal ryk og spillerens position overskrider feltlistens længde, trækkes den fra
	//			p.getAccount().addSum(4000); //Start bonus
	//		}
	//		else
	//		{
	//			p.setPlayerPos(p.getPlayerPos() + amountOfMoves);
	//		}
	//	}

	public Player[] addPlayer()
	{
		Player[] player = new Player[out.howManyPlayers()]; // Opretter antal spillere fra input i GUI

		for( int i = 0 ; i < player.length ; i++ )
		{ 
			String name = GUI.getUserString(Language.getNameOfPlayer() + " " + (i + 1)); //input navn fra GUI(skal laves i Output)

			player[i] = new Player(name);
			player[i].setPlayerPos(0);
			out.addPlayersToGUI(player[i]);
		}

		return player; //
	}

	public void resetOwnedFields(Player p)
	{
		if(p.getBankruptStatus() == true) 
		{
			for(int i = 0; i < Fieldlist.getFields().length;i++)
			{
				if(Fieldlist.getFields()[i] instanceof Ownabel)
				{
					if( ((Ownabel) Fieldlist.getFields()[i]).getOwner() == p )
					{
						((Ownabel) Fieldlist.getFields()[i]).setOwner(null);
						out.removeOwner(p.getPlayerPos()+1);
					}
				}
			}
		}
	}

	public void goBankrupt(Player p)
	{
		if(p.getAccount().getSum() <= 0)
		{
			
			p.setBankrupt(true);
			resetOwnedFields(p);
			GUI.removeCar(p.getPlayerPos(), p.getName());
		}
	}

	public void winner()
	{

		int playersAlive = 0;

		for (int i = 0; i < player.length; i++) 
		{ 
			Player p = player[i];
			boolean bankrupt = p.getBankruptStatus(); // Tjekker om spillere er bankrupt
			if(!bankrupt) playersAlive++; //ligger en til hver gang spilleren ikke er bankrupt
		}

		if(playersAlive == 1)
		{ 

			for (int i = 0; i < player.length; i++) 
			{ // Tjekker HVILKEN spiller der er tilbage

				Player p = player[i];
				boolean bankrupt = p.getBankruptStatus();

				if(!bankrupt) 
				{
					out.msgGUI(Language.getWinnerText() + " " + p.getName()); //Prøver at holde pause i 10 sekunder efter vinder er fundet. Ellers laver den exception så programmet ikke crasher
					GUI.close();
					endGame = true;
				}
			}
		}
	}
	
	public Player[] getPlayerArray(){
		return player;
	}
}



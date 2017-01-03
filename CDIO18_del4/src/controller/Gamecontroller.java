package controller;

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

import desktop_resources.GUI;
import model.Dicecup;
import model.Player;
import model.fields.Fieldlist;
import tests.FakeDicecup;
import tests.TestData;
import view.Output;

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
		new Gamecontroller().setup();
	}
	
	public Gamecontroller(){
		this(new Output());
	}
	
	public Gamecontroller(Output o){
		out = o;
		list = new Fieldlist(out);
	}

	public void setup()
	{
		out.drawGameboard(list);
		testMode = out.setTestMode(); 	// Giver spilleren mulighed for at gå i test mode og tildeler til testMode boolean

		if(testMode)
		{ // Kode der bliver kørt vis programmet er i test mode!
			cup = new FakeDicecup();
		}
		else
		{
			cup = new Dicecup();
		}

		numberOfPlayers = out.howManyPlayers();
		players = out.addplayers(players, startSum);


		update();
	}

	public void update()
	{
		while(!gameEnded)
		{
			for(int i=0; i < players.length; i++)
			{
				winner(players[i]);

				if(!(players[i].getAccount().getSum() <= 0))
				{
					turn(players[i]);
				}
				else 
				{
					players[i].setBankrupt(true);
				}
			}
		}
	}

	private void winner(Player p)
	{
		int con = 0;

		for(int i =0; i < players.length; i++)
		{
			if(players[i].getBankruptStatus())
			{
				con++;
			}
		}

		if(con == numberOfPlayers - 1)
		{
			out.winnerPrint(p);
			GUI.close();
		}
	}

	public static int getNumberOfPlayers() 
	{
		return numberOfPlayers;
	}

	private void turn(Player p)
	{
		out.msgGUI(list.getFields()[p.getCarPos() - 1].getDescription());
		cup.roll(); // ryster raflebærger 
		int sum = cup.getSum(); // sikre at det kun er nødvenrtigt at kalde cup.getSum() en gang! - vigtigt i test mode!

		if(testMode)
			out.setGUIDice(TestData.getLinedata()[0], TestData.getLinedata()[1]);
		else
			out.setGUIDice(cup.getDie1().getValue(), cup.getDie2().getValue());

		out.removeCar(p);
		out.setcar(sum, p, list);

		list.getFields()[p.getCarPos()-1].landOn(p);

		out.setGUIBalance(p);

		winner(p);
		System.out.println();
	}
}


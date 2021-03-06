package controller;

import java.util.ArrayList;
import java.util.List;

import desktop_resources.GUI;
import model.Dicecup;
import model.Player;
import model.cards.Deck;
import model.fields.Field;
import model.fields.Fieldlist;
import model.fields.Ownable;
import model.fields.Plot;
import view.Language;
import view.Out;
import view.Output;

/*
 * Team 18 - CDIO 3   
 * DTU
 * Collaborators:  KasperLeiszner, Bijan Negari, Helene Zgaya, Frederik von Scholten and Troels Lund
 * 
 *							   ___                               _  ___  	__   __    ___
 *							  / _ \_ __ _   _ _ __  _ __   ___  / |( _ ) 	\ \_/ /  /  _  \
 *							 / /_\/ '__| | | | '_ \| '_ \ / _ \ | |/ _ \ 	 \   /  |  / \  |
 *							/ /_\\| |  | |_| | |_) | |_) |  __/ | | (_) |     | |   |  \_/  |
 *							\____/|_|   \__,_| .__/| .__/ \___| |_|\___/      |_|    \ ___ / 
 *							                 |_|   |_|                   
 * 
 * 
 */

/*
 * Class wrote by: Troels Lund and Kasper Leiszner
 */

public class Gamecontroller 
{
	private static Player[] player;
	
	public static  Player[] getPlayer() {
		return player;
	}

	private Dicecup cup = new Dicecup();
	private Out out;
	private boolean endGame;
	private MoveController movecontroller = new MoveController();

	public static void main(String[] args) 
	{
		new Gamecontroller(new Output()).setup(); //Opretter objekt af gamecontroller og kalder setup
	}

//	public Gamecontroller()
//	{
//		this(new Output()); //Kalder kontruktøren nedenunder. 
//	}

	public Gamecontroller(Out out) //Ved test bruges kun denne konstruktør og ikke den ovenstående.
	{
		this.out = out; 
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

			Field f = Fieldlist.getFields()[p.getPlayerPos()];
			f.landOn(p, out); // Kalder landOn for spillerens position i feltlistens array

			for (int i = 0; i < player.length; i++) 
			{
				out.setGUIBalance(player[i]);
			}

			goBankrupt();
			winner(); 
			checkPlots(p, out);
			
//			if(){
//				
//			}

			if(cup.getDie1().getValue() == cup.getDie2().getValue()){

				out.msgGUI(Language.extraTurn(p));

				turn(p);
			}
		}	
		
		System.out.println();
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

		switch (out.Jailaction(p, option))
		{ // hvad skal der ske når man vægler en af de tre mulighder?:
		
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
			
			if(cup.getDie1().getValue() == cup.getDie2().getValue())
			{
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
				if(Fieldlist.getFields()[i] instanceof Ownable)
				{
					if( ((Ownable) Fieldlist.getFields()[i]).getOwner() == p )
					{
						((Ownable) Fieldlist.getFields()[i]).setOwner(null);
						out.removeOwner(p.getPlayerPos()+1);
					}
				}
			}
		}
	}

	public void goBankrupt()
	{
		for (int i = 0; i < player.length; i++) 
		{
			if(player[i].getAccount().getSum() <= 0)
			{
				player[i].setBankrupt(true);
				resetOwnedFields(player[i]);
				GUI.removeCar(player[i].getPlayerPos(), player[i].getName());
			}
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
					out.closeGame();
					endGame = true;
				}
			}
		}
	}
	
	public Player[] getPlayerArray(){
		return player;
	}
	
	public void checkPlots(Player p, Out out){

		int[] gruppeNumre = generateBoughtFieldArray(p); // udfylder gruppenumre med data om havd spilleren ejer
		List<Field> flist = addPlotsToList(gruppeNumre); // tjekker om spiller ejer alle grunde i en gruppe, og giver tilbage en liste med fields som han kan bygge på.

		
		if(flist.size() < 1){ // vis der ikke er nogle grunde i flist - STOP her. 
			return;
		}
		
		if(out.shopOrNot()){
			if(out.sellOrBuy()){

				String result = out.whereToBuild(generateNameArray(flist)); // spørg i GUI

				int index = findIndexOfField(result); // finder index for placering af field der skal bygges på.

				buyHouse(p,result,index);

			}
			else{

				String result = out.whereToSell(generateNameArraySell(flist));

				int index = findIndexOfField(result);

				sellHouse(p,result,index);

			}
		}
		
	}
	
	private int[] generateBoughtFieldArray(Player p){

		int[] gruppeNumre = new int[8];

		for(int i = 0; i < Fieldlist.getFields().length; i++)	// for-loop der kører alle felter igennem.
		{
			if(Fieldlist.getFields()[i] instanceof Plot)		// Sorterer alle felter der IKKE er plot fra. Vi tjekker altså om det specifik felt er et Plot-felt.
			{	
				Plot plot = (Plot) Fieldlist.getFields()[i];	// caster feltet vi ved er et Plot til et Plot ås vi kan få adgang til GroupNumber
				if(plot.getOwner() != null && plot.getOwner().equals(p)){ // tjekker at plot har en owner og derved ikke er Null og der næst at owneren er den samme som den spiller osm har tur
					//TODO
					gruppeNumre[plot.getGroupNumber()-1] += 1;  // tilføjer at du har købt en den type grund til array.
				}

			}
		}
		return gruppeNumre;
	}
	
	private List<Field>  addPlotsToList(int[] gruppeNumre){
		
		List<Field> flist = new ArrayList<>();
		int[] maxPlot = {2, 3, 3, 3, 3, 3, 3, 2};
		boolean[] canBuild = new boolean[8];
		
		for (int i = 0; i < maxPlot.length; i++) { // du kan bygge vis antalet af grunde inde for en type er det samme som hvad du max kan få. 
			if(gruppeNumre[i] == maxPlot[i]){
				canBuild[i] = true;
			}
		}
		
		for (int i = 0; i < canBuild.length; i++) { // adder gruppe til mulig byggegrunde. 
			if(canBuild[i]){
				
				//TODO
				flist.addAll(getGroup(i+1));
			}
		}
		
		return flist;
		
	}
	
	private String[] generateNameArray(List<Field> flist){
		
		String[] FieldNames = new String[flist.size()]; // opretter array.
		
		
		for (int i = 0; i < flist.size(); i++) { // sætter navne på felter ind i Navne-array
			FieldNames[i] = flist.get(i).getName();
		}
		return FieldNames;
	}
	
	public List<Field> getGroup(int x){
		List<Field> flist = new ArrayList<>(); 
		for (Field f : Fieldlist.getFields()) {
			if(f instanceof Plot ){
				Plot p = (Plot) f;
				if(p.getGroupNumber() == x){
					flist.add(p);
				}
			}
		}
		return flist;	
	}

	private int findIndexOfField(String result){
		for (int i = 0; i < Fieldlist.getFields().length; i++) {
			if(Fieldlist.getFields()[i].getName().equals(result)) {
				return i;
			}
		}
		return 0;
	}
	
	private String[] generateNameArraySell(List<Field> flist){

		String[] FieldNames = new String[flist.size()]; // opretter array.


		for (int i = 0; i < flist.size(); i++) { // sætter navne på felter ind i Navne-array
			if(flist.get(i) instanceof Plot){
				Plot p =(Plot) flist.get(i);
				if(p.getHousecount() > 0){
					FieldNames[i] = flist.get(i).getName();

				}
			}
		}
		return FieldNames;
	}
	
	private void buyHouse(Player p, String result, int index){
		
			Field f = Fieldlist.getFields()[index];
			if(f.getName().equals(result)){
				if(f instanceof Plot ){
					Plot plotCast =(Plot) f;
					plotCast.upgradePlot();
					if(plotCast.getHousecount() >= 5){ // bygger hotel vis der er 5 huse.
						out.BuildHotel(index+1, true);
						p.getAccount().withdraw(200);
					}
					else{
						out.BuildHouse(index+1, plotCast.getHousecount()); // bygger huse vis der er mindre end 5 huse.
						p.getAccount().withdraw(200);
					}
					
				}
				
			}
	}
	
	
private void sellHouse(Player p, String result, int index){
		
		for (int i = 0; i < Fieldlist.getFields().length; i++) {
			Field f = Fieldlist.getFields()[i];
			if(f.getName().equals(result)){
				if(f instanceof Plot ){
					Plot plotCast =(Plot) f;
					plotCast.downgradePlot();
					if(plotCast.getHousecount() >= 5){ // bygger hotel vis der er 5 huse.
						out.BuildHotel(index, false);
						p.getAccount().addSum(200);
						out.BuildHouse(index+1, plotCast.getHousecount());
					}
					else{
						out.BuildHouse(index+1, plotCast.getHousecount()); // bygger huse vis der er mindre end 5 huse.
						p.getAccount().addSum(200);
					}
					
				}
				
			}
		}
		
		
	}
}



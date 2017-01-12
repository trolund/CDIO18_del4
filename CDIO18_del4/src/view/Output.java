package view;

/*
 * Class wrote by: Troels Lund and Kasper Leiszner
 */

import desktop_fields.Street;
import desktop_resources.GUI;
import model.Player;
import model.fields.Fieldlist;

public class Output extends Out
{

	public void winnerPrint(Player p)
	{
		System.out.println(Language.getWinnerText() + " " + p.getName());
		GUI.showMessage(Language.getWinnerText() + " " + p.getName());
	}

	public void oneMoreGame()
	{
		System.out.println(Language.getEndText());
		GUI.showMessage(Language.getEndText());
	}

	public int howManyPlayers()
	{
		int result = Integer.parseInt(GUI.getUserSelection(Language.getPlayerCountText(), "2","3","4","5","6"));
		System.out.println(result + " players are made");
		return result; 
	}

	public void drawGameboard()
	{
		model.fields.Field[] logicField = Fieldlist.getFields();
		desktop_fields.Field[] guiField = new desktop_fields.Field[logicField.length];

		for (int i = 0; i < logicField.length; i++) 
		{
			guiField[i] = new Street.Builder()
					.setTitle(logicField[i].getName())
					.setDescription(logicField[i].getDescription())
					.setRent("" + logicField[i].getValue())
					.build();
		}

		GUI.create(guiField);
	}

	public boolean taxAction(int price)
	{
		Boolean result = GUI.getUserLeftButtonPressed(Language.getMakeYourChoiceMSG(), Language.getPayMSG() + " " + price , Language.getTenPercent());
		System.out.println("You did pay the normal tax " + result + " .If false you payed 10%");
		return result;
	}

	public void setGUIDice(int die1 , int die2)
	{
		System.out.println("You rolled " + die1 + " " + die2 + " The sum is " + (die1 + die2));
		GUI.setDice(die1,die2);
	}

	public void setGUIBalance(Player p)
	{
		System.out.println("Your new balance is " + p.getAccount().getSum());
		GUI.setBalance(p.getName(), p.getAccount().getSum());
	}

	public void setcar(Player p)
	{
		System.out.println(p.getName() + " - Gui car is moved to field number " + (p.getPlayerPos()+1));
		
		GUI.setCar(p.getPlayerPos()+1,p.getName());
	}

	public void msgGUI(String s)
	{
		System.out.println(s);
		GUI.showMessage(s);
	}
	
	public void rollDiceText()
	{
		GUI.getUserButtonPressed("", Language.rollDiceText());
	}

	public void addPlayersToGUI(Player player)
	{
		GUI.addPlayer(player.getName(), player.getAccount().getSum());
		GUI.setCar(1, player.getName());
	}

	public boolean shopField(int price, Player p)
	{
		boolean x = GUI.getUserLeftButtonPressed(p.getName() + " " + Language.getWillYouBuy() + " " + price, Language.getYesNo()[0], Language.getYesNo()[1]);
		
		
		return x;
	}

	public boolean setTestMode()
	{
		return GUI.getUserLeftButtonPressed(Language.testModeStrings(0),Language.testModeStrings(1),Language.testModeStrings(2));
	}

	public void verificationOfPurchase()
	{
		GUI.showMessage(Language.purchaseString());
		System.out.println("You bought this field");
	}

	public void deniedPurchase()
	{
		GUI.showMessage(Language.deniedPurchaseString());
		System.out.println("You didn't buy the field");
	}
	
	public void removeCar(Player p)
	{
		GUI.removeCar(p.getPlayerPos()+1, p.getName());
		System.out.println(p.getName() + " car got removed in GUI");
	}
	
	public void setColor(Player p)
	{
		GUI.setOwner(p.getPlayerPos()+1, p.getName());
		System.out.println("Owner was set");
	}
	
	public void payedRent(Player p, int rent)
	{
		GUI.showMessage(p.getName() + ", " + Language.payedRent() + " " + rent );
		System.out.println("Field is owned, you paid the rent");
	}
	
	public void ownField()
	{
		GUI.showMessage("It's your own field - nothing happened");
		System.out.println("It's your own field - nothing happened");
	}
	
	public void landMSG(Player p)
	{
		GUI.showMessage(p.getName() + " has landed on " + Fieldlist.getFields()[p.getPlayerPos()].getClass().getSimpleName());
		System.out.println(p.getName() + " has landed on " + Fieldlist.getFields()[p.getPlayerPos()].getClass().getSimpleName());
	}
	
	public String Jailaction(Player p, String[] array){
		return GUI.getUserButtonPressed("Vil du slå med terningerne eller betale", array);
	}

	@Override
	public void removeOwner(int fieldNum) 
	{
		//TODO
		GUI.removeOwner(fieldNum);
	}
	
	public void CardsOut(String dis){
		GUI.displayChanceCard("Chancekort: " + dis );
	}
	public void closeGame()
	{
		GUI.close();
	}
	
	public void build(Player p, Out out, String farve){
		
	}
	
	public String whereToBuild(String[] fArray){
		String result = GUI.getUserSelection("Hvor vil du bygge? - Det vil koste dig 200kr at bygge", fArray);
		return result;
	}
	
	public String whereToSell(String[] fArray){
		String result = GUI.getUserSelection("Hvad for en bygning vil du sælge?", fArray);
		return result;
	}
	
	public void BuildHouse(int index, int houseCount){
		GUI.setHouses(index, houseCount);
	}
	
	public void BuildHotel(int index, boolean hasHotel){
		GUI.setHotel(index, hasHotel);
		
	}
	
	public boolean sellOrBuy(){
		return GUI.getUserLeftButtonPressed("Vil du købe eller sælg husse?", "køb", "sælg");
		
	}
	
	public boolean shopOrNot(){
		return GUI.getUserLeftButtonPressed("vil du handle eller ej?", "ja", "nej");
		
	}
	
	public String convertToColor(int group){
		switch(group){
		case 0: return "lyseblå";
		case 1: return "lyserød";	
		case 2: return "grøn";	
		case 3: return "grå";	
		case 4: return "rød";	
		case 5: return "hvid";
		case 6: return "gul";	
		case 7: return "brun";	
		}
		return null;
		
	}
	
}




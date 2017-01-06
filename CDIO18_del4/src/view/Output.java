package view;

/*
 * Class wrote by: Troels Lund and Kasper Leiszner
 */

import desktop_fields.Street;
import desktop_resources.GUI;
import model.Player;
import model.fields.Field;
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

	public void drawGameboard(Fieldlist fd)
	{
		model.fields.Field[] logicField = fd.getFields();
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
		System.out.println("You did pay the tax" + result + "If false you payed 10%");
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
		System.out.println("Gui car is moved to field number " + (p.getPlayerPos()+1));
		GUI.removeCar(p.getPlayerPos()+1, p.getName());
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
		return GUI.getUserLeftButtonPressed(p.getName() + " " + Language.getWillYouBuy() + " " + price, Language.getYesNo()[0], Language.getYesNo()[1]);
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
		GUI.removeAllCars(p.getName());
		System.out.println("All cars got removed in GUI");
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

	@Override
	public void removeOwner(int fieldNum) 
	{
		//TODO
		GUI.removeOwner(fieldNum);
	}
	

}




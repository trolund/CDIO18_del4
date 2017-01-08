package view;

import model.Player;

public abstract class Out {
	
	public abstract void winnerPrint(Player p);

	public abstract void oneMoreGame();

	public abstract int howManyPlayers();

	public abstract void drawGameboard();

	public abstract boolean taxAction(int price);

	public abstract void setGUIDice(int die1 , int die2);
	
	public abstract void setGUIBalance(Player p);

	public abstract void setcar(Player p);

	public abstract void msgGUI(String s);

	public abstract void addPlayersToGUI(Player player);

	public abstract boolean setTestMode();

	public abstract void verificationOfPurchase();

	public abstract void deniedPurchase();

	public abstract void rollDiceText();
	
	public abstract boolean shopField(int price, Player p);

	public abstract void setColor(Player p);
	
	public abstract void payedRent(Player p, int rent);
	
	public abstract void landMSG(Player p);
	
	public abstract void removeOwner(int fieldNum);
	
	public abstract String Jailaction(Player p, String[] array);
	
	public abstract void removeCar(Player p);
	
	public abstract void CardsOut(String dis);

}

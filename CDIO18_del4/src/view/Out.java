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

	public abstract void closeGame();
	
	public abstract void build(Player p, Out out, String farve);
	
	public abstract String whereToBuild(String[] fArray);
	
	public abstract void BuildHouse(int index, int houseCount);
	
	public abstract void BuildHotel(int index, boolean hasHotel);
	
	public abstract boolean sellOrBuy();
	
	public abstract String whereToSell(String[] fArray);
	
	public abstract boolean shopOrNot();
		
}

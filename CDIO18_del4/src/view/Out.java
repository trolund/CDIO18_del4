package view;

import controller.Gamecontroller;
import desktop_fields.Street;
import desktop_resources.GUI;
import model.Player;
import model.fields.Fieldlist;

public abstract class Out {
	
	public abstract void winnerPrint(Player p);

	public abstract void oneMoreGame();

	public abstract int howManyPlayers();

	public abstract void turnMsg(int nr, Player p, String s);

	public abstract void drawGameboard(Fieldlist fd);

	public abstract boolean taxAction(int price);

	public abstract void setGUIDice(int die1 , int die2);
	
	public abstract void setGUIBalance(Player p);
	
	public abstract void GUIcreateFields(desktop_fields.Field[] f);

	public abstract void setcar(int no, Player p, Fieldlist list);

	public abstract void msgGUI(String s);

	public abstract Player[] addplayers(Player[] players, int startSum);

	public abstract boolean shop(int price, Player p);

	public abstract boolean setTestMode();

	public abstract void verificationOfPurchase();

	public abstract void deniedPurchase();

	public abstract void rollDiceText();
	
	public abstract void shopField();

	

}

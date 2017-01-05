package view;

import desktop_fields.Field;
import model.Player;
import model.fields.Fieldlist;

public class FakeOutput extends Out {
	
	
	public boolean taxAction(int taxAmmount){
		return false;
	}

	@Override
	public void winnerPrint(Player p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void oneMoreGame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int howManyPlayers() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void turnMsg(int nr, Player p, String s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawGameboard(Fieldlist fd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setGUIDice(int die1, int die2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setGUIBalance(Player p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void GUIcreateFields(Field[] f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setcar(int no, Player p, Fieldlist list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void msgGUI(String s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Player[] addplayers(Player[] players, int startSum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean shop(int price, Player p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setTestMode() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void verificationOfPurchase() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deniedPurchase() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rollDiceText() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shopField() {
		// TODO Auto-generated method stub
		
	}

}
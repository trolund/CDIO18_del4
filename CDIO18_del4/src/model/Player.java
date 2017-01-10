package model;

import java.util.ArrayList;

import model.cards.FreeJailCard;

public class Player 
{

	private String name;
	private BankAccount account;
	private boolean bankruptStatus = false;
	private int playerPos = 0;
	private int breweryCount = 0;
	private int fleetCount = 0;
	private boolean isJailed = false;
	private ArrayList<FreeJailCard> jailcards = new ArrayList<FreeJailCard>();

	public ArrayList<FreeJailCard> getJailcards() {
		return jailcards;
	}

	public void setJailcards(ArrayList<FreeJailCard> jailcards) {
		this.jailcards = jailcards;
	}

	public boolean isJailed() {
		return isJailed;
	}

	public void setJailed(boolean isJailed) {
		this.isJailed = isJailed;
	}

	public Player(String name) 
	{
		this.name = name;
		account = new BankAccount(1500);
	}	

	public BankAccount getAccount() 
	{
		return account;
	}

	public String getName() 
	{
		return name;
	}

	public boolean getBankruptStatus() 
	{
		return bankruptStatus;
	}


	public void setBankrupt(boolean bankruptStatus) 
	{
		this.bankruptStatus = bankruptStatus;
	}

	public int getPlayerPos() 
	{
		return playerPos;
	}

	public void setPlayerPos(int newCarPos) 
	{
		this.playerPos = newCarPos;
	}

	public void setBreweryCount(int newCount)
	{
		breweryCount = newCount;
	}

	public int getBreweryCount()
	{
		return breweryCount;
	}

	public void setFleetCount(int newCount)
	{
		fleetCount = newCount;
	}

	public int getFleetCount()
	{
		return fleetCount;
	}
	
	
	
}

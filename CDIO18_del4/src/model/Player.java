package model;

import java.util.ArrayList;

import desktop_fields.Ownable;

public class Player 
{

	private String name;
	private BankAccount account;
	private boolean bankruptStatus = false;
	private int playerPos = 0;
	private int breweryCount = 0;
	private int fleetCount = 0;
	private ArrayList<Ownable> ownedFields = new ArrayList<>();

	public Player(String name, int balance) 
	{
		this.name = name;
		account = new BankAccount(balance);
	}	
	
	public ArrayList<Ownable> getOwnedFields() {
		return ownedFields;
	}
	public void addOwnedFields(Ownable ownedField) {
		this.ownedFields.add(ownedField);
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

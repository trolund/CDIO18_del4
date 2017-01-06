package model;

public class Player 
{

	private String name;
	private BankAccount account;
	private boolean bankruptStatus = false;
	private int playerPos = 0;
	private int breweryCount = 0;
	private int fleetCount = 0;

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

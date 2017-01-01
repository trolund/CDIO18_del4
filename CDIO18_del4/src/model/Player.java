package model;

import model.fields.Fieldlist;

public class Player {

	private String name;
	private BankAccount account;
	private boolean bankrupt = false;
	private int carPos = 0;
	private int laborCount = 0;
	private int fleetCount = 0;

	public Player(int balance, String name) {
		this.name = name;
		account = new BankAccount(balance);
	}	


	public BankAccount getAccount() {
		return account;
	}

	public String getName() {
		return name;
	}


	public boolean getBankruptStatus() {
		return bankrupt;
	}


	public void setBankrupt(boolean bankrupt) {
		this.bankrupt = bankrupt;
	}


	public int getCarPos() {
		return carPos;
	}


	public void setCarPos(int carPos) {
		this.carPos = carPos;
	}

	public void moveCarPos(int carPos, Fieldlist list) 
	{
		if(this.carPos + carPos > list.getFields().length)
		{
			this.carPos = (this.carPos + carPos) - list.getFields().length;
		}
		else
		{
			this.carPos += carPos;
		}
	}

	public void setLaborcampCount(int newCount)
	{
		laborCount = newCount;
	}

	public int getLaborcampCount()
	{
		return laborCount;
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

package model;

public class BankAccount 
{
	private int balance;

	public BankAccount(int balance){
		this.balance = balance > 0 ? balance : 0;
	}

	public int getSum(){
		return balance;
	}

	public boolean setSum(int value) 
	{
		if(value >= 0)
		{
			balance = value;
			return true;
		}
		
		return false;
	}

	public boolean addSum(int value) 
	{
		if (value > 0)
		{
			balance += value;
			return false;
		}
		
		return true;
	}	

	public boolean withdraw(int value) 
	{
		if(value < 0 && value * (-1) > balance)
		{
			balance -= value;
			return true;
		}
		else 
		{
			balance = 0;
			return false;	
		}	
	}
}

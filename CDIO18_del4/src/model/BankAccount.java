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

	public void setSum(int value) 
	{
		if(value < 0)
		{
			balance = 0;
		}
		else
		{
			balance = value;
		}
		
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
		if(value > 0 && (balance - value) > 0 )
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

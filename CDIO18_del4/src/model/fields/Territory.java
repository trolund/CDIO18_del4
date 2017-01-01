package model.fields;

import model.Player;
import view.Output;

public class Territory extends Ownable
{
	private int rent;

	public Territory(String name, String description, int price, int rent) 
	{
		super(name, description, price);
		this.rent = rent;
	}
	
	@Override
	public void landOn(Player p)
	{
		Output.landMSG(p,this);
		
		if(p.getAccount().getSum()>=price && getOwner() == null)
		{
			// can buy
			wantToBuy = Output.shop(price, p);
			
			if(wantToBuy)
			{
				Output.setColor(p);
				setOwner(p);
				p.getAccount().withdraw(price);
				Output.verificationOfPurchase();
			}
		}
		else if(p.getAccount().getSum() < price && getOwner() == null)
		{
			// cant affort
			Output.deniedPurchase();
		}
		else if(p.getAccount().getSum()>=price && getOwner() == null && !wantToBuy)
		{
			//Player don't want to buy
			Output.deniedPurchase();
		}
		else if(getOwner() != null && getOwner() != p)// is owned
		{
			// Pay rent
			p.getAccount().withdraw(getRent(getOwner()));
			getOwner().getAccount().addSum(getRent(getOwner()));
			Output.payedRent(p, getRent(getOwner()));
		}
		else
		{
			//It's your own field
			Output.ownField();
		}
	}

	@Override
	public int getRent(Player p) 
	{
		// ignore player
		return rent;
	}
}



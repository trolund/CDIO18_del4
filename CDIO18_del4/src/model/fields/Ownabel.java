package model.fields;

import model.Player;
import view.Output;


public abstract class Ownabel extends Field
{	protected int price;
private Player owner;
boolean wantToBuy;

public Ownabel (String name, String description, int price, Output o)
{
	super(name, description, o);
	this.price = price;
}

@Override
public void landOn(Player p)
{

	if(p.getAccount().getSum()>=price && owner == null)
	{
		// can buy
		wantToBuy = out.shop(price, p);

		if(wantToBuy)
		{
			out.setColor(p);
			setOwner(p);
			if(this instanceof Brewery){
				p.setLaborcampCount(p.getLaborcampCount() + 1);
			}
			if(this instanceof Fleet){
				p.setFleetCount(p.getFleetCount()+1);
			}

			p.getAccount().withdraw(price);
			out.verificationOfPurchase();
		}
	}
	else if(p.getAccount().getSum() < price && owner == null)
	{
		// cant affort
		out.deniedPurchase();
	}
	else if(p.getAccount().getSum()>=price && owner == null && !wantToBuy)
	{
		//Player don't want to buy
		out.deniedPurchase();
	}
	else if(owner != null && owner != p)// is owned
	{
		// Pay rent

		int rent = getRent(p);

		p.getAccount().withdraw(rent);
		owner.getAccount().addSum(rent);
		out.payedRent(p, rent);
	}
	else
	{
		//It's your own field
		System.out.println("It's your own field");
	}
}

public abstract int getRent(Player p);

public int getValue()
{
	return price;
}

public void setOwner(Player owner) 
{
	this.owner = owner;
}	

public Player getOwner()
{
	return owner;
}
}
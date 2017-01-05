package model.fields;

import model.Player;
import view.Out;
import view.Output;


public abstract class Ownabel extends Field
{	

	protected int price;
	private Player owner;
	boolean wantToBuy;

	public Ownabel (String name, String description, int price, Out o)
	{
		super(name, description, o);
		this.price = price;
	}

	@Override
	public void landOn(Player p, Output o)
	{
		if(p.getAccount().getSum()>=price && owner == null) // can buy
		{	
			wantToBuy = o.shop(price, p);

			if(wantToBuy)
			{
				o.setColor(p);
				setOwner(p);

				if(this instanceof Brewery)
				{
					p.setBreweryCount(p.getBreweryCount() + 1);
				}

				if(this instanceof Fleet)
				{
					p.setFleetCount(p.getFleetCount()+1);
				}

				p.getAccount().withdraw(price);
				o.verificationOfPurchase();
			}
		}
		else if(p.getAccount().getSum() < price && owner == null)	// cant affort
		{
			o.deniedPurchase();
		}
		else if(p.getAccount().getSum()>=price && owner == null && !wantToBuy)	//Player don't want to buy
		{
			o.deniedPurchase();
		}
		else if(owner != null && owner != p)	// is owned
		{
			int rent = getRent(p);

			// Pay rent
			p.getAccount().withdraw(rent);
			owner.getAccount().addSum(rent);
			o.payedRent(p, rent);
		}
		else	//It's your own field
		{
			System.out.println("It's your own field");
		}
	}

	public abstract int getRent(Player p);

	public int getValue()
	{
		return price;
	}

	public void setOwner(Player owner){
		this.owner = owner;
	}	

	public Player getOwner(){
		return owner;
	}

}
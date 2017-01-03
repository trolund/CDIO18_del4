package model.fields;

import model.Player;
import view.Output;

public abstract class Ownabel extends Field
{	protected int price;
	private Player owner;
	boolean wantToBuy;

	public Ownabel (String name, String description, int price)
	{
		super(name, description);
		this.price = price;
	}

	@Override
	public void landOn(Player p)
	{
		System.out.println(p.getName() + " has landed on ownable field");
		
		if(p.getAccount().getSum()>=price && owner == null)
		{
			// can buy
			wantToBuy = Output.shop(price, p);
			
			if(wantToBuy)
			{
				Output.setColor(p);
				setOwner(p);
				if(this instanceof Brewery){
					p.setLaborcampCount(p.getLaborcampCount() + 1);
				}
				if(this instanceof Fleet){
					p.setFleetCount(p.getFleetCount()+1);
				}
				
				p.getAccount().withdraw(price);
				Output.verificationOfPurchase();
			}
		}
		else if(p.getAccount().getSum() < price && owner == null)
		{
			// cant affort
			Output.deniedPurchase();
		}
		else if(p.getAccount().getSum()>=price && owner == null && !wantToBuy)
		{
			//Player don't want to buy
			Output.deniedPurchase();
		}
		else if(owner != null && owner != p)// is owned
		{
			// Pay rent
			
			int rent = getRent(p);
			
			p.getAccount().withdraw(rent);
			owner.getAccount().addSum(rent);
			Output.payedRent(p, rent);
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
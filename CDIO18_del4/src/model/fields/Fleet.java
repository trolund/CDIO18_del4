package model.fields;

import model.Player;
import view.Output;

public class Fleet extends Ownable
{
private int baseRent;


	public Fleet(String name, String description, int price, int baseRent) 
	{
		super(name, description, price);
		this.baseRent = baseRent;
	}
	
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
				
				p.setFleetCount(p.getFleetCount() + 1);
				System.out.println(p + " Fleet count: " + p.getFleetCount());
				
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
	public int getRent(Player p) {
		return (int) (baseRent * Math.pow(2, p.getFleetCount() - 1));
		
	}
}

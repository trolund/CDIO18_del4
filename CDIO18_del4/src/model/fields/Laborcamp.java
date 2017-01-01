package model.fields;

import model.Dicecup;
import model.Player;
import view.Output;

public class Laborcamp extends Ownable
{
	private int baseRent;

	public Laborcamp(String name, String description, int price, int baseRent) 
	{
		super(name, description, price);
		this.baseRent = baseRent;
		
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

					p.setLaborcampCount(p.getLaborcampCount() + 1);
					System.out.println(p + " Labor count: " + p.getLaborcampCount());
				
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
		Dicecup cup = new Dicecup();
		cup.getDie1().roll();
		cup.getDie2().roll();
		int sum = cup.getSum();
		Output.setGUIDice(cup.getDie1().getValue(), cup.getDie2().getValue());
		return sum * baseRent * p.getLaborcampCount();
	}

}
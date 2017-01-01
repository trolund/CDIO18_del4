package model.fields;

import model.Player;
import view.Output;

public abstract class Ownable extends Field
{	protected int price;
	private Player owner;
	boolean wantToBuy;

	public Ownable (String name, String description, int price)
	{
		super(name, description);
		this.price = price;
	}

	@Override
	public abstract void landOn(Player p);
//	{
//		System.out.println(p.getName() + " has landed on ownable field");
//		
//		if(p.getAccount().getSum()>=price && owner == null)
//		{
//			// can buy
//			wantToBuy = Output.shop(price, p);
//			
//			if(wantToBuy)
//			{
//				Output.setColor(p);
//				setOwner(p);
//
//				if(p.getCarPos() == 13 || p.getCarPos() == 14) //Magic numbers!!! Wooo!!! Det skal være færdigt nu :D
//				{
//					p.setLaborcampCount(p.getLaborcampCount() + 1);
//					System.out.println(p + " Labor count: " + p.getLaborcampCount());
//				}
//				else if(p.getCarPos() == 17 || p.getCarPos() == 18 || p.getCarPos() == 19 || p.getCarPos() == 20) //Endnu flere! Hvad vil du gøre ved det maaaan
//				{
//					p.setFleetCount(p.getFleetCount() + 1);
//					System.out.println(p + " Fleet count: " + p.getFleetCount());
//				}
//					
//				p.getAccount().withdraw(price);
//				Output.verificationOfPurchase();
//				System.out.println("You bought this field");
//			}
//		}
//		else if(p.getAccount().getSum() < price && owner == null)
//		{
//			// cant affort
//			Output.deniedPurchase();
//			System.out.println("You can't affort");
//		}
//		else if(p.getAccount().getSum()>=price && owner == null && !wantToBuy)
//		{
//			//Player don't want to buy
//			Output.deniedPurchase();
//			System.out.println("You didn't buy the field");
//		}
//		else if(owner != null && owner != p)// is owned
//		{
//			// Pay rent
//			p.getAccount().withdraw(getRent(owner));
//			owner.getAccount().addSum(getRent(owner));
//			System.out.println("Field is owned, you paid the rent");
//			Output.payedRent(p, getRent(owner));
//		}
//		else
//		{
//			//It's your own field
//			System.out.println("It's your own field");
//		}
//	}

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
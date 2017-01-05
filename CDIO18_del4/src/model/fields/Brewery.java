package model.fields;

import model.Dicecup;
import model.Player;
import view.Out;
import view.Output;

public class Brewery extends Ownabel
{
	private int baseRent;

	public Brewery(String name, String description, int price, int baseRent, Out out) 
	{
		super(name, description, price,out);
		this.baseRent = baseRent;
	}

	@Override
	public int getRent(Player p) 
	{
		if (this.getOwner().getBreweryCount() > 1) 
		{
			baseRent += 6;
		}
		
		Dicecup cup = new Dicecup();
		
		out.rollDiceText();
		cup.roll();
		out.setGUIDice(cup.getDie1().getValue(), cup.getDie2().getValue());
		
		int sum = cup.getSum();
		int rent = sum * baseRent;
		
		return rent;
	}

}
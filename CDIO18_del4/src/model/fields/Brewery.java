package model.fields;

import model.Dicecup;
import model.Player;
import view.Out;

public class Brewery extends Ownabel
{
	private int baseRent;

	public Brewery(String name, String description, int price, int baseRent, Out out) 
	{
		super(name, description, price,out);
		this.baseRent = baseRent;
	}

	@Override
	public int getRent(Player p)	// baseRent er 4. Så man ganger 4 med antal øjne. Men har man begge brewery
	{								// bliver baseRent 10. Derfor ligger vi 6 til i "if".
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
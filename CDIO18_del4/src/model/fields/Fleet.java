package model.fields;

import model.Player;
import view.Out;

public class Fleet extends Ownabel
{
	
	private int baseRent;

	public Fleet(String name, String description, int price, int baseRent, Out out) 
	{
		super(name, description, price,out);
		this.baseRent = baseRent;
	}

	@Override
	public int getRent(Player p) 
	{
		return (int) (baseRent * Math.pow(2, p.getFleetCount() - 1));
	}
}

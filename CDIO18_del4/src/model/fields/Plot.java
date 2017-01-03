package model.fields;

import model.Player;
import view.Output;

public class Plot extends Ownabel
{
	private int rent;

	public Plot(String name, String description, int price, int rent) 
	{
		super(name, description, price);
		this.rent = rent;
	}
	

	@Override
	public int getRent(Player p) 
	{
		// ignore player
		return rent;
	}
}



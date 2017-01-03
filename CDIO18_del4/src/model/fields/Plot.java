package model.fields;

import model.Player;
import view.Output;

public class Plot extends Ownabel
{
	private int rent;

	public Plot(String name, String description, int price, int rent, Output o) 
	{
		super(name, description, price, o);
		this.rent = rent;
	}
	

	@Override
	public int getRent(Player p) 
	{
		// ignore player
		return rent;
	}
}



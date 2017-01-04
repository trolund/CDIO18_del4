package model.fields;

import model.Player;
import view.Output;

public class Parking extends Field
{
	private int bonus;

	public Parking(String name, String description, int bonus, Output o) 
	{
		super(name, description, o);
		this.bonus = bonus;
	}

	@Override
	public void landOn(Player p, Output o)
	{	
		p.getAccount().addSum(bonus);
	}

	public int getValue()
	{
		return bonus;
	}

}

package model.fields;

import model.Player;
import view.Out;
import view.Output;

public class Parking extends Field
{
	
	private int bonus;

	public Parking(String name, String description, int bonus, Out out) 
	{
		super(name, description, out);
		this.bonus = bonus;
	}

	@Override
	public void landOn(Player p, Out o)
	{	
		p.getAccount().addSum(bonus);
	}

	public int getValue()
	{
		return bonus;
	}

}

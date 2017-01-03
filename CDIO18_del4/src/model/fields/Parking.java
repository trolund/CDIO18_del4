package model.fields;

import model.Player;

public class Parking extends Field
{
	private int bonus;

	public Parking(String name, String description, int bonus) 
	{
		super(name, description);
		this.bonus = bonus;
	}

	@Override
	public void landOn(Player p)
	{	
		p.getAccount().addSum(bonus);
	}

	public int getValue()
	{
		return bonus;
	}

}

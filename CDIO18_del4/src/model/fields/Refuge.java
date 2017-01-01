package model.fields;

import model.Player;

/**
 * 
 * @author von Scholten
 *
 */

public class Refuge extends Field
{
	private int bonus;

	public Refuge(String name, String description, int bonus) 
	{
		super(name, description);
		this.bonus = bonus;
	}

	@Override
	public void landOn(Player p)
	{	
		p.getAccount().addSum(bonus);
		System.err.println("refuge");
	}
	
	public int getValue()
	{
		return bonus;
	}
	
}

package model.fields;

import model.Player;
import view.Output;

public class Chance extends Field
{
	public Chance(String name, String description, Output o)
	{
		super(name, description, o);
	}
	
	public void landOn(Player p, Output o)
	{
		
	}
	
	public int getValue()
	{
		return 9999999;
	}
}

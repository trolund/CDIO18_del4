package model.fields;

import model.Player;
import view.Out;
import view.Output;

public class Chance extends Field
{
	public Chance(String name, String description, Out out)
	{
		super(name, description, out);
	}
	
	public void landOn(Player p, Output o)
	{
		
	}
	
	public int getValue()
	{
		return 9999999;
	}
}

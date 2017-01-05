package model.fields;

import model.Player;
import view.Output;

public class Prison extends Field 
{
	public Prison(String name, String decsription, Output o)
	{
		super(name, decsription, o);
	}
	
	public void landOn(Player player, Output o)
	{
		
	}
	
	public int getValue()
	{
		return 999999999;
	}
}

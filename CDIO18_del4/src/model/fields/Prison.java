package model.fields;

import model.Player;
import view.Out;
import view.Output;

public class Prison extends Field 
{
	public Prison(String name, String decsription, Out out)
	{
		super(name, decsription, out);
	}
	
	public void landOn(Player player, Out o)
	{
		
	}
	
	public int getValue()
	{
		return 999999999;
	}
}

package model.fields;

import model.Player;
import view.Out;
import view.Output;

public class GoToPrison extends Field 
{
	public GoToPrison(String name, String decsription, Out out)
	{
		super(name, decsription, out);
	}
	
	public void landOn(Player p, Out o)
	{
		p.setJailed(true);
		p.setPlayerPos(11);
	}
	
	public int getValue()
	{
		return 999999999;
	}
}

package model.fields;

import desktop_resources.GUI;
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
		out.removeCar(p);
		p.setPlayerPos(10);
		out.setcar(p);
	}
	
	public int getValue()
	{
		return 999999999;
	}
}

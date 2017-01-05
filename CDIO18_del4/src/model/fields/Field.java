package model.fields;

import model.Player;
import view.Out;
import view.Output;

public abstract class Field 
{
	private String name = "None";
	private String description = "";
	protected Out out;
	
	public Field(String name, String description, Out o)
	{
		this.name = name;
		this.description = description;
		out = o;
	}

	public String getName()
	{
		return name;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public abstract void landOn(Player p, Output o);

	public String toString()
	{
		return 	"Name: " + name + "\n" + 
				"Description: " + description;
	}

	public abstract int getValue();

	
}
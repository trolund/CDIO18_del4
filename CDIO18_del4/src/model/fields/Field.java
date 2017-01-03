package model.fields;

import model.Player;
import view.Output;

public abstract class Field 
{
	private String name = "None";
	private String description = "";
	protected Output out;
	
	public Field(String name, String description, Output o)
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
	
	public abstract void landOn(Player p);

	public String toString()
	{
		return 	"Name: " + name + "\n" + 
				"Description: " + description;
	}

	public abstract int getValue();
}
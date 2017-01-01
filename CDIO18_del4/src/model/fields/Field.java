package model.fields;

import model.Player;

public abstract class Field 
{
	private String name = "None";
	private String description = "";
	
	public Field(String name, String description)
	{
		this.name = name;
		this.description = description;
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
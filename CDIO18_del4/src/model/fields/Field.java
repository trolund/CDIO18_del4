package model.fields;

import model.Player;
import view.Out;

public abstract class Field // Field klassen er abstract fordi vi ikke vil kunne oprette et objekt af Field.
							// Vi vil gerne kunne specificere hvilket slags field det er. Det er for generalt at oprette et obejkt af field. 
{
	protected String name = "None";
	protected String description = "";
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
	
	public abstract void landOn(Player p, Out o);

	public String toString()
	{
		return 	"Name: " + name + "\n" + 
				"Description: " + description;
	}

	public abstract int getValue();

	
}
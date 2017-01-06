package model.fields;

import model.Player;
import view.Out;

public class Plot extends Ownabel
{
	private int groupNumber;
	private int rent;
	private boolean[] house = new boolean[6];

	public Plot(String name, String description, int price, int rent, Out out, int groupNumber){
		super(name, description, price, out);
		this.rent = rent;
		this.groupNumber = groupNumber;
	}

	@Override
	public int getRent(Player p)
	{
		// ignore player
		for(int i = 0; i < Fieldlist.getFields().length; i++)	// for-loop der kører alle felter igennem.
		{
			if(Fieldlist.getFields()[i] instanceof Plot)		// Sorterer alle felter der IKKE er plot fra. Vi tjekker altså om det specifik felt er et Plot-felt.
			{													
																// Vi caster felterne til et Plot, så vi kan tilgå groupNumber, og caster igen så vi kan tilgå Owner af felterne.
																// Og tjekker først om groupNumber er det samme, altså om de er i samme gruppe. Og derefter om ejeren er forskellig.
				if(((Plot) Fieldlist.getFields()[i]).getGroupNumber() == this.groupNumber && ((Plot) Fieldlist.getFields()[i]).getOwner() != this.getOwner())	
				{												
					return rent;								// Returner normal rent.
				}
			}
		}
			
		return 2*rent;											// Returnerer double rent.
			
	}
	
	
	public int getGroupNumber(){
		return groupNumber;
	}

	public void buildhouse(){
		for (int i = 0; i < house.length; i++) {
			if(!(house[i])){
				// der kan bygges og der bliver bygget på den første ledige grund.
				house[i] = true;
				break;
			}

			else{
				// vil du bygge et hotel?
			} 

		}


	}

}



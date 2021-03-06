package model.fields;

import model.Player;
import view.Out;

public class Plot extends Ownable
{
	private int groupNumber;
	private int rent;
	private int housecount = 0;

	public Plot(String name, String description, int price, int rent, Out out, int groupNumber) {
		super(name, description, price, out);
		this.rent = rent;
		// this.rent sætter attributen der blev oprettet i klassen lig..
		this.groupNumber = groupNumber;
		// this.groupNumber sætter attributen der blev oprettet i klassen lig..
	}

	@Override // overrider getRent metoden i Ownable klassen
	public int getRent(Player p) {
		// ignore player?
		for (int i = 0; i < Fieldlist.getFields().length; i++)
		// for-loop der kører alle felter igennem.
		{
			if (Fieldlist.getFields()[i] instanceof Plot)
			// Sorterer alle felter der IKKE er plot fra. Vi tjekker altså om
			// det specifik felt er et Plot-felt.
			{
				if (((Plot) Fieldlist.getFields()[i]).getGroupNumber() == this.groupNumber
						&& ((Plot) Fieldlist.getFields()[i]).getOwner() != this.getOwner())
				// Vi caster felterne til et Plot, så vi kan tilgå groupNumber,
				// og caster igen så vi kan tilgå Owner af felterne.
				// Og tjekker først om groupNumber er det samme, altså om de er
				// i samme gruppe. Og derefter om ejeren er forskellig.

				{
					return rent;
					// Returner normal rent.
				}
			}
		}
		return 2 * rent * housecount;
		// Returnerer double rent.
	}
	
	
	public int getGroupNumber(){
		return groupNumber;
	}

	
	
	public void upgradePlot() {
		if (housecount <= 5) {
			// "if" sørger for at housecount ikke kan blive 5 men ikke mere end
			// 5
			housecount++;
			// øger housecount hver gang upgradePlot metoden kører
		}
	}
	
	public void downgradePlot() {
		if (!(housecount <= 0)) {
			
			housecount--;
		
		}
	}

	public int getHousecount() { // get metode
		return housecount;
	}

	}




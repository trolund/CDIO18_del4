package model.fields;

import model.Dicecup;
import model.Player;
import view.Out;

public class Brewery extends Ownable
// Brewery klassen arver (extender) fra Ownable
{
	private int baseRent;
	Dicecup cup = new Dicecup();

	public Brewery(String name, String description, int price, int baseRent, Out out) {
		super(name, description, price, out);
		this.baseRent = baseRent;
		// this.baseRent sætter attributen der blev oprettet i klassen lig..
	}

	@Override
	public int getRent(Player p)
	// baseRent er 4. Så man ganger 4 med antal øjne. Men har man begge brewery
	// bliver baseRent 10. Derfor ligger vi 6 til i "if".

	{ //
		if (this.getOwner().getBreweryCount() > 1)
		// hvis denne spiller (Player p) har flere end et brewery
		{
			baseRent += 6;
			// kan også skrives: baseRent = baseRent + 6
		}
		
		// opretter et nyt Dicecup objekt
		out.rollDiceText();
		// besked i GUI (Kast terningerne)
		cup.roll();
		// kalder metoden rool i cup;
		out.setGUIDice(cup.getDie1().getValue(), cup.getDie2().getValue());
		// viser terningernes værdier i GUI
		int sum = cup.getSum();
		// kalder kalder metoden getSum i cup og sætter sum lig return
		int rent = sum * baseRent;
		// sætter rent lig terningernes sum gange baseRent

		return rent;
	}
	
	public Dicecup getDiceCup()
	{
		return cup;
	}

}
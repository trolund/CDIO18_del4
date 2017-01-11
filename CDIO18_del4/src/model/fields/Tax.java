package model.fields;

import model.Player;
import view.Out;

public class Tax extends Field
// Tax-klassen arver (extender) fra Field-klassen
{

	private int taxAmmount; // det faste beløb du skal betale
	private int taxRate; // en procent af din formue du skal betale

	public Tax(String name, String description, int taxAmmount, int taxRate, Out out) {
		super(name, description, out);
		this.taxAmmount = taxAmmount;
		// this.taxAmmount sætter attributen der blev oprettet i klassen lig..
		this.taxRate = taxRate;
		// this.taxRate sætter attributen der blev oprettet i klassen lig..
	}

	@Override
	public void landOn(Player p, Out o) {
		if (taxRate > 0)
		// hvis taxRaten (i Fieldlist) er sat større end 0 så kan spilleren
		// vælge at betale taxAmmount eller taxRate
		{
			if (out.taxAction(taxAmmount))
			// hvis spilleren vælger taxAmmount
			{
				p.getAccount().withdraw(taxAmmount);
				// trækker vha. withdraw metoden
				out.msgGUI("You have paid " + taxAmmount + " in tax");
				// besked i GUI
				System.out.println("You have paid " + taxAmmount + " in tax");
				// besked i konsol
			} else {
				int value = (taxRate * p.getAccount().getSum()) / 100;
				// sætter value lig taxRate (formellen)

				p.getAccount().withdraw(value);
				// trækker value vha. withdraw metoden
				out.msgGUI("You have paid " + value + " in tax");
				// besked i GUI
				System.out.println("You have paid " + value + " in tax");
				// besked i konsol

			}
		} else // ellers (hvis taxRate er 0) så skal spilleren betale taxAmmount
		{
			p.getAccount().withdraw(taxAmmount);
			// trækker vha withdraw metoden
			out.msgGUI("You have paid " + taxAmmount + " in tax");
			// besked i GUI
			System.out.println("You have paid " + taxAmmount + " in tax");
			// besked i konsol
		}
	}

	public int getValue() // get metode
	{
		return taxAmmount;
	}

}
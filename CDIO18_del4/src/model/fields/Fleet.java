package model.fields;

import model.Player;
import view.Out;

public class Fleet extends Ownable
// Fleet arver (extender) fra Ownable
{

	private int baseRent;
	// this.baseRent

	public Fleet(String name, String description, int price, int baseRent, Out out) {
		super(name, description, price, out);
		this.baseRent = baseRent;
		// this.baseRent sætter attributten der blev oprettet i klassen lig..
	}

	@Override
	public int getRent(Player p) // get metode
	{
		return (int) (baseRent * Math.pow(2, (p.getFleetCount() - 1)));
		// returnere Fleet-feltets rent vha. formlen
	}
}

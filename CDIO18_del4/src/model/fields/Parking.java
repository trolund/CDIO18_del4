package model.fields;

import model.Player;
import view.Out;

public class Parking extends Field {
	// Parking-klassen arver (extender) fra Field-klassen

	private int bonus;

	public Parking(String name, String description, int bonus, Out out) {
		super(name, description, out);
		this.bonus = bonus;
		// this.bonus er den bonus attributten der blev oprettet i linje 8
	}

	@Override
	public void landOn(Player p, Out o) // skal bruge parametrene Player og Out
	{
		p.getAccount().addSum(bonus);
		// kalder addSum i Player p's account der lægger (bonus) til dit account

	}

	public int getValue() // get metode returnere bonus
	{
		return bonus;
	}

}

package model.fields;

import model.Dicecup;
import model.Player;
import view.Output;

public class Brewery extends Ownabel
{
	private int baseRent;

	public Brewery(String name, String description, int price, int baseRent) 
	{
		super(name, description, price);
		this.baseRent = baseRent;
	}

	@Override
	public int getRent(Player p) 
	{
		Dicecup cup = new Dicecup();
		cup.roll();
		Output.setGUIDice(cup.getDie1().getValue(), cup.getDie2().getValue());
		int sum = cup.getSum();
		int rent = sum * baseRent * p.getBreweryCount();
		Output.msgGUI("Du slog " + cup.getSum()+ " og skal derfor betale"+ rent);
		return rent;
	}

}
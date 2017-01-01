package model.fields;

import model.Player;
import view.Output;

public class Fleet extends Ownable
{
private int baseRent;


	public Fleet(String name, String description, int price, int baseRent) 
	{
		super(name, description, price);
		this.baseRent = baseRent;
	}
	

	@Override
	public int getRent(Player p) {
		
		p.setFleetCount(p.getFleetCount() + 1);
		System.out.println(p + " Fleet count: " + p.getFleetCount());
		
		return (int) (baseRent * Math.pow(2, p.getFleetCount() - 1));
		
	}
}

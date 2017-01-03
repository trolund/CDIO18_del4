package model.fields;

import model.Player;
import view.Output;

/**
 * 
 * @author von Scholten
 *
 */

public class Tax extends Field {

	private int taxAmmount;
	private int taxRate;

	public Tax(String name, String description, int taxAmmount, int taxRate) 
	{
		super(name, description);
		this.taxAmmount = taxAmmount;
		this.taxRate = taxRate;
	}

	@Override
	public void landOn(Player p)
	{
		if(taxRate > 0)
		{
			if(Output.taxAction(taxAmmount))
			{
				p.getAccount().withdraw(taxAmmount);
			}
			else
			{
				p.getAccount().withdraw((taxRate*p.getAccount().getSum())/100);
			}
		}
		else
		{
			p.getAccount().withdraw(taxAmmount);
		}
	}
	
	public int getValue()
	{
		return taxAmmount;
	}
}
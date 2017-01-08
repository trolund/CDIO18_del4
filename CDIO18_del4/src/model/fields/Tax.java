package model.fields;

import model.Player;
import view.Out;

/**
 * 
 * @author von Scholten
 *
 */

public class Tax extends Field 
{

	private int taxAmmount;
	private int taxRate;

	public Tax(String name, String description, int taxAmmount, int taxRate, Out out) 
	{
		super(name, description,out);
		this.taxAmmount = taxAmmount;
		this.taxRate = taxRate;
	}

	@Override
	public void landOn(Player p, Out o)
	{
		if(taxRate > 0)
		{
			if(out.taxAction(taxAmmount))
			{
				p.getAccount().withdraw(taxAmmount);
				out.msgGUI("You have paid " + taxAmmount + " in tax");
				System.out.println("You have paid " + taxAmmount + " in tax");
			}
			else
			{
				p.getAccount().withdraw((taxRate*p.getAccount().getSum())/100);
				out.msgGUI("You have paid " + (taxRate*p.getAccount().getSum())/100 + " in tax");
				System.out.println("You have paid " + (taxRate*p.getAccount().getSum())/100 + " in tax");
			}
		}
		else
		{
			p.getAccount().withdraw(taxAmmount);
			out.msgGUI("You have paid " + taxAmmount + " in tax");
			System.out.println("You have paid " + taxAmmount + " in tax");
		}
	}
	
	public int getValue()
	{
		return taxAmmount;
	}
	
}
package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.fields.*;
import view.FakeOutput;
import view.Output;
import model.Player;;

public class JUnitTestTax 
{
	Output out = new FakeOutput();
	
	@Test
	public void TC01() 
	{
		
		Player p = new Player("Kasper");
		Fieldlist list = new Fieldlist(out);
		
		int exRes = p.getAccount().getSum() - 4000;
		
		//Chooses to pay 4000
		list.getFields()[17].landOn(p);

		int res = p.getAccount().getSum();
		
		assertEquals(exRes, res);
	}

	@Test
	public void TC02() 
	{
		Player p = new Player("Kasper");
		Fieldlist list = new Fieldlist(out);
		
		int exRes = p.getAccount().getSum() - ((30000 * 10)/100);
		
		//Chooses to pay 10 percent
		list.getFields()[17].landOn(p);

		int res = p.getAccount().getSum();
		
		assertEquals(exRes, res);
	}
}

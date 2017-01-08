package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.fields.*;
import view.FakeOutput;
import view.Out;
import model.Player;;

public class JUnitTestTax 
{
	Out out = new FakeOutput();
	
	@Test
	public void TC01() 
	{
		
		Player p = new Player("Kasper");
		
		int exRes = p.getAccount().getSum() - 200;
		
		//Chooses to pay 4000
		Fieldlist.getFields()[4].landOn(p,out);

		int res = p.getAccount().getSum();
		
		assertEquals(exRes, res);
	}

	@Test
	public void TC02() 
	{
		Player p = new Player("Kasper");
		
		int exRes = p.getAccount().getSum() - ((1500 * 10)/100);
		
		//Chooses to pay 10 percent
		Fieldlist.getFields()[4].landOn(p, out);

		int res = p.getAccount().getSum();
		
		assertEquals(exRes, res);
	}
}

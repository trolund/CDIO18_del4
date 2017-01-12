package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.fields.*;
import view.FakeOutputFalse;
import view.FakeOutputTrue;
import view.Out;
import model.Player;;

public class JUnitTestTax 
{
	Out outTrue = new FakeOutputTrue();
	Out outFalse = new FakeOutputFalse();
	
	@Test
	public void TC01() 
	{
		
		Player p = new Player("Kasper");
		
		int exRes = (p.getAccount().getSum() - (10 * 1500) / 100);
		
		new Fieldlist(outFalse);
		Fieldlist.getFields()[4].landOn(p, outFalse);
		
		int res = p.getAccount().getSum();
		
		assertEquals(exRes, res);
	}

	@Test
	public void TC02() 
	{
		Player p = new Player("Kasper");
		
		int exRes = p.getAccount().getSum() - 100;

		new Fieldlist(outTrue);
		Fieldlist.getFields()[38].landOn(p, outTrue);

		int res = p.getAccount().getSum();
		
		assertEquals(exRes, res);
	}
}

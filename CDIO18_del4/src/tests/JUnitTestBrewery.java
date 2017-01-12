package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Player;
import model.fields.Brewery;
import model.fields.Fieldlist;
import view.FakeOutputTrue;
import view.Out;

public class JUnitTestBrewery 
{
	
	private Out outTrue = new FakeOutputTrue();

	@Test
	public void TC01()
	{
		Player [] p = {new Player("player1"), new Player("player2")};
		new Fieldlist(outTrue);
		
		int exRe = p[0].getAccount().getSum() - 150;
		Fieldlist.getFields()[12].landOn(p[0],outTrue);

		int Re = p[0].getAccount().getSum();
		
		assertEquals(exRe,Re);
	}
	
	@Test
	public void test2()
	{ 
		Player [] p = {new Player("p1"),new Player("p2")};
		new Fieldlist(outTrue);
		
		if(Fieldlist.getFields()[12] instanceof Brewery)
		{		
			Brewery br = (Brewery) Fieldlist.getFields()[12];
			br.setOwner(p[0]);
			br.landOn(p[1], outTrue);

			int Re = p[1].getAccount().getSum();
			int exRe = 1500 - (4 * br.getDiceCup().getSum());
			
			assertEquals(exRe, Re);
		}
	}

}

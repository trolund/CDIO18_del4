package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Player;
import model.fields.Fieldlist;
import model.fields.Ownabel;
import view.FakeOutput;
import view.Out;

public class JUnitTestBrewery 
{
	
	private Out out = new FakeOutput();

	@Test
	public void TC01()
	{
		Player [] p = {new Player("player1"), new Player("player2")};
		new Fieldlist(out);
		
		int exRe = p[0].getAccount().getSum() - 150;
		Fieldlist.getFields()[12].landOn(p[0],out);

		int Re = p[0].getAccount().getSum();
		
		assertEquals(exRe,Re);
	}
	
	@Test
	public void test2()
	{ 
		Player [] p = {new Player("p1"),new Player("p2")};
		new Fieldlist(out);
		
		if(Fieldlist.getFields()[12] instanceof Ownabel)
		{		
			Ownabel br = (Ownabel) Fieldlist.getFields()[12];
			br.setOwner(p[0]);
		}
		
		int exRe = p[1].getAccount().getSum();
		
		Fieldlist.getFields()[12].landOn(p[1], out);
		
		int Re = p[1].getAccount().getSum();
		
		assertEquals(exRe,Re, 48);
	}

}

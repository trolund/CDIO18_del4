package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import desktop_fields.Brewery;
import model.Player;
import model.fields.Fieldlist;
import model.fields.Ownabel;
import view.FakeOutput;
import view.Out;
import view.Output;

public class JUnitTestBrewery {
	
	private Out out = new FakeOutput();

	@Test
	public void test() //Spiller lander på felt og køber. 
	{
		Player [] p = {new Player("p1"),new Player("p2")};

		
		out.setcar(p[0]);
		int exRe = p[0].getAccount().getSum()-1000;
		Fieldlist.getFields()[12].landOn(p[0],out);

		int Re = p[0].getAccount().getSum();
		assertEquals(exRe,Re);
		
	}
	
	@Test
	public void test2() //Spiller lander felt eget af anden spiller og betaler afgift
	{ 
			
		Player [] p = {new Player("p1"),new Player("p2")};
		
		if(Fieldlist.getFields()[12] instanceof Ownabel){		
			Ownabel br = (Ownabel) Fieldlist.getFields()[12];
			br.setOwner(p[0]);
		}
		
		out.setcar(p[1]);
		
		int exRe = p[1].getAccount().getSum()-100;

		
		Fieldlist.getFields()[1].landOn(p[0]);
		// spiller 0 køber feltet 
		
		f.getFields()[1].landOn(p[1]);
		int Re = p[1].getAccount().getSum();
		

		assertEquals(exRe,Re);
	}

}

package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Player;
import model.fields.Fieldlist;
import view.Output;

public class JUnitTestTerritory {
	
	private Output out = new Output();

	@Test
	public void test() //Spiller lander på felt og køber. 
	{
		Player [] p = {new Player(30000,"p1"),new Player(30000,"p2")};
		Fieldlist f = new Fieldlist();
		
		out.setcar(1, p[0], f);
		int exRe = p[0].getAccount().getSum()-1000;
		f.getFields()[1].landOn(p[0]);

		int Re = p[0].getAccount().getSum();
		assertEquals(exRe,Re);
		
	}
	
	@Test
	public void test2() //Spiller lander felt eget af anden spiller og betaler afgift
	{
		Player [] p = {new Player(30000,"p1"),new Player(30000,"p2")};
		Fieldlist f = new Fieldlist();
		
		out.setcar(1, p[0], f);
		
		int exRe = p[1].getAccount().getSum()-100;

		
		f.getFields()[1].landOn(p[0]);
		// spiller 0 køber feltet 
		
		f.getFields()[1].landOn(p[1]);
		int Re = p[1].getAccount().getSum();
		

		assertEquals(exRe,Re);
	}

}

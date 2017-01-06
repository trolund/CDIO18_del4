package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Player;
import model.fields.Fieldlist;
import view.FakeOutput;
import view.Out;
import view.Output;



public class JUnitTestFleet {
	
	private Out out = new FakeOutput();
	
	//Player p = new Player(balance, name);

			Player bijan = new Player("Bijan");
			Player kasper = new Player("Kasper");
			Fieldlist list = new Fieldlist(out);

	@Test
	public void test() {

		out.setcar(18, bijan, list);
		// bijan lander på felt 18
		list.getFields()[18].landOn(bijan, out);
		// bijan køber feltet

		list.getFields()[18].landOn(kasper, out);
		assertEquals(16500, bijan.getAccount().getSum());	// Efter bijan har købt et fleet felt, lander kasper på samme felt, og overhøre 500 
		assertEquals(29500, kasper.getAccount().getSum());	// dask til bijan.

		// bijan lander herefter på felt 19
		list.getFields()[19].landOn(bijan, out);
		// og køber endnu en fleet

		list.getFields()[18].landOn(kasper, out);
		assertEquals(13500, bijan.getAccount().getSum());	// bijan køber endnu et fleet felt, og kasper lander uheldigvis på samme felt.
		assertEquals(28500, kasper.getAccount().getSum());	// nu må han betale 1000, da bijan ejer 2 fleets

		
		out.setcar(21, bijan, list);
		// bijan lander på felt 21
		list.getFields()[21].landOn(bijan, out);
		// bijan køber feltet
		
		
		list.getFields()[21].landOn(kasper, out);
		assertEquals(11500, bijan.getAccount().getSum());	// det samme bro, bare nu med 3 fleets
		assertEquals(26500, kasper.getAccount().getSum());	// betaler 2000 
		
		
		
		
		
		
		
		
	}
}

package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Player;
import model.fields.Fieldlist;
import view.FakeOutputTrue;
import view.Out;

public class JUnitTestFleet 
{

	private Out out = new FakeOutputTrue();
	private Player bijan = new Player("Bijan");
	private Player kasper = new Player("Kasper");

	@Test
	public void test() 
	{
		new Fieldlist(out);
		
		Fieldlist.getFields()[5].landOn(bijan, out);
		Fieldlist.getFields()[5].landOn(kasper, out);
		
		assertEquals(1500-200+25, bijan.getAccount().getSum());	 
		assertEquals(1500-25, kasper.getAccount().getSum());	

		Fieldlist.getFields()[15].landOn(bijan, out);
		Fieldlist.getFields()[15].landOn(kasper, out);

		assertEquals(1500-200*2+75, bijan.getAccount().getSum());	// bijan køber endnu et fleet felt, og kasper lander uheldigvis på samme felt.
		assertEquals(1500-25-50, kasper.getAccount().getSum());	// nu må han betale 1000, da bijan ejer 2 fleets


		Fieldlist.getFields()[25].landOn(bijan, out);
		Fieldlist.getFields()[25].landOn(kasper, out);

		assertEquals(1500-200*3+175, bijan.getAccount().getSum());	// det samme bro, bare nu med 3 fleets
		assertEquals(1500-25-50-100, kasper.getAccount().getSum());	// betaler 2000 
		
		Fieldlist.getFields()[35].landOn(bijan, out);
		Fieldlist.getFields()[35].landOn(kasper, out);

		assertEquals(1500-200*4+375, bijan.getAccount().getSum());	// det samme bro, bare nu med 3 fleets
		assertEquals(1500-25-50-100-200, kasper.getAccount().getSum());	
	}
}

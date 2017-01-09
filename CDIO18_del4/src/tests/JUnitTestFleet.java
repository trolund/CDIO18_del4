package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Player;
import model.fields.Fieldlist;
import view.FakeOutput;
import view.Out;

public class JUnitTestFleet 
{

	private Out out = new FakeOutput();
	private Player bijan = new Player("Bijan");
	private Player kasper = new Player("Kasper");

	@Test
	public void test() 
	{
		Fieldlist.getFields()[5].landOn(bijan, out);
		Fieldlist.getFields()[5].landOn(kasper, out);
		
		assertEquals(1550, bijan.getAccount().getSum());	 
		assertEquals(29500, kasper.getAccount().getSum());	

		Fieldlist.getFields()[19].landOn(bijan, out);
		Fieldlist.getFields()[18].landOn(kasper, out);

		assertEquals(13500, bijan.getAccount().getSum());	// bijan køber endnu et fleet felt, og kasper lander uheldigvis på samme felt.
		assertEquals(28500, kasper.getAccount().getSum());	// nu må han betale 1000, da bijan ejer 2 fleets


		Fieldlist.getFields()[21].landOn(bijan, out);
		Fieldlist.getFields()[21].landOn(kasper, out);

		assertEquals(11500, bijan.getAccount().getSum());	// det samme bro, bare nu med 3 fleets
		assertEquals(26500, kasper.getAccount().getSum());	// betaler 2000 
	}
}

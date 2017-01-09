package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Player;

public class JUnitTestPlayer {

	@Test
	public void testPLayer() {  
		
		Player p = new Player("Knud");
	
		assertEquals("Knud", p.getName());
		assertEquals(50, p.getAccount().getSum());
		
		p.getAccount().setSum(0);
		assertEquals(0, p.getAccount().getSum());
		
		p.getAccount().setSum(100);
		p.getAccount().addSum(200);
		assertEquals(300, p.getAccount().getSum());
		
		assertEquals(p.getAccount(), p.getAccount());
		
		p.getAccount().addSum(-500);
		assertEquals(0, p.getAccount().getSum());
		
		Player p2 = new Player("Brian");
		
		assertEquals(0, p2.getAccount().getSum()); // summen må ikke være negativ 
		
		p2.getAccount().setSum(-250000);
		
		assertEquals(0, p2.getAccount().getSum()); // summen må ikke være negativ
		
	}

}

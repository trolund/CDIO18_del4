package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Player;
import model.fields.Fieldlist;

public class JUnitTestRefuge {

	@Test
	public void test() {
		Player p = new Player(30000,"hej");
		Fieldlist f = new Fieldlist();
		
		f.getFields() [12].landOn(p);
		assertEquals(35000,p.getAccount().getSum());
	}

}

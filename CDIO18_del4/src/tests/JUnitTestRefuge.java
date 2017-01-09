package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Player;
import model.fields.Fieldlist;
import view.FakeOutput;
import view.Out;

public class JUnitTestRefuge {

	@Test
	public void test() {
		Player p = new Player("hej");
		Out out = new FakeOutput();
		
		Fieldlist.getFields() [12].landOn(p, out);
		assertEquals(35000,p.getAccount().getSum());
	}

}

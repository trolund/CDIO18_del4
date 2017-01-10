package tests;
import static org.junit.Assert.*;

import org.junit.Test;

import model.fields.Fieldlist;
import view.FakeOutput;
import view.Out;

public class JUnitTestFieldlist 
{
	
	
	Out out = new FakeOutput();
	
	@Test
	public void test01() 
	{
		String exsName;
		new Fieldlist(out);
		
		exsName = Fieldlist.getFields()[1].getName();

//		assertEquals(exsValue, 1000);
		assertEquals(exsName, "Rødovrevej");  // tester at navner passer.
//		assertEquals(exsDescription, "Rødovrevej");		
	}
}

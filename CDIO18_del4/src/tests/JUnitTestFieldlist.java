package tests;
import static org.junit.Assert.*;

import org.junit.Test;

import model.fields.Field;
import model.fields.Fieldlist;
import view.FakeOutput;
import view.Out;

public class JUnitTestFieldlist 
{
	
	
	Out out = new FakeOutput();
	
	@Test
	public void test01() 
	{
		int exsValue;
		String exsName;
		String exsDescription;
		Field[] fdList = new Fieldlist(out).getFields();
		
		exsValue = fdList[1].getValue();
		exsName = fdList[1].getName();
		exsDescription = fdList[1].getDescription();

//		assertEquals(exsValue, 1000);
		assertEquals(exsName, "Rødovrevej");  // tester at navner passer.
//		assertEquals(exsDescription, "Rødovrevej");		
	}
}

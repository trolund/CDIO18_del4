package tests;
import static org.junit.Assert.*;

import org.junit.Test;

import model.fields.Field;
import model.fields.Fieldlist;

public class JUnitTestFieldlist 
{
	@Test
	public void test01() 
	{
		int exsValue;
		String exsName;
		String exsDescription;
		Field[] fdList = new Fieldlist().getFields();
		
		exsValue = fdList[1].getValue();
		exsName = fdList[1].getName();
		exsDescription = fdList[1].getDescription();

		assertEquals(exsValue, 1000);
		assertEquals(exsName, "Tribe Encampment");
		assertEquals(exsDescription, "Territory");		
	}
}

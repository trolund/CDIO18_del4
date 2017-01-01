package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Player;
import model.fields.Fieldlist;
import view.Output;

public class JUnitTestLaborcamp 
{

	@Test
	public void TC01() 
	{
		Player[] p = {new Player(30000, "Kasper"), new Player(30000, "Troels")};
		Fieldlist fdList = new Fieldlist();
		
		Output.drawGameboard(fdList);
		Output.howManyPlayers();
		Output.addplayers(p, 30000);
		
		//You DO NOT buy the field
		fdList.getFields()[14].landOn(p[0]);
		int exRes = 30000;
		int res = p[0].getAccount().getSum();
		
		assertEquals(exRes, res);
	}

	
	
	
	
	
	@Test
	public void TC02() 
	{
		Player[] p = {new Player(30000, "Kasper"), new Player(30000, "Troels")};
		Fieldlist fdList = new Fieldlist();
		
		Output.drawGameboard(fdList);
		Output.howManyPlayers();
		Output.addplayers(p, 30000);
		Output.setcar(1, p[0], fdList);

		//You DO buy the field
		fdList.getFields()[14].landOn(p[0]);
		int exRes = 30000 - 2500;
		int res = p[0].getAccount().getSum();
		
		assertEquals(exRes, res);
	}
	
	
	@Test
	public void TC03() 
	{
		Player[] p = {new Player(30000, "Kasper"), new Player(30000, "Troels")};
		Fieldlist fdList = new Fieldlist();
		
		Output.drawGameboard(fdList);
		Output.howManyPlayers();
		Output.addplayers(p, 30000);
		Output.setcar(14, p[0], fdList);

		int exRes = p[1].getAccount().getSum();
		
		//You DO buy the fields
		fdList.getFields()[14].landOn(p[0]);
		
		Output.setcar(14, p[0], fdList);
		fdList.getFields()[15].landOn(p[0]);
		
		fdList.getFields()[14].landOn(p[1]);

		int res = p[1].getAccount().getSum();
		
		assertEquals(exRes, res, 2400);
	}
}

package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.Gamecontroller;
import model.fields.*;
import view.FakeOutput;
import view.Out;
import model.Player;;

public class JUnitTestTax 
{
	Out out = new FakeOutput();
	
	@Test
	public void TC01() 
	{
		
		Player p = new Player("Kasper");
		
		int exRes = (p.getAccount().getSum() - (10 * 1500) / 100);
		
		new Fieldlist(out);
		Fieldlist.getFields()[4].landOn(p, out);
		
		int res = p.getAccount().getSum();
		
		assertEquals(exRes, res);
	}

	@Test
	public void TC02() 
	{
		Player p = new Player("Kasper");
		
		int exRes = p.getAccount().getSum() - 100;

		new Fieldlist(out);
		Fieldlist.getFields()[38].landOn(p, out);

		int res = p.getAccount().getSum();
		
		assertEquals(exRes, res);
	}
	
	@Test
	public void TC03()
	{
		Player player = new Player("Kasper");
		Gamecontroller gameCon = new Gamecontroller();
		new Fieldlist(out);
		
		Boolean exRes = true;
		
		player.getAccount().setSum(100);
		Fieldlist.getFields()[38].landOn(player, out);
		gameCon.goBankrupt(player);
		
		Boolean res = player.getBankruptStatus();
		
		assertEquals(exRes, res);
	}
}

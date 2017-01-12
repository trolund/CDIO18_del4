package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.MoveController;
import model.Player;
import model.fields.Fieldlist;
import view.FakeOutputTrue;
import view.Out;

public class JUnitTestStartField 
{

	@Test
	public void TC01() 
	{
		Player player = new Player("Kasper");
		Out out = new FakeOutputTrue();
		MoveController moveCon = new MoveController();
		new Fieldlist(out);

		player.setPlayerPos(35);
		moveCon.movePlayer(5, player);
		
		Fieldlist.getFields()[player.getPlayerPos()].landOn(player, out);
		
		int exRes = 1500 + 200;
		int res = player.getAccount().getSum();
		
		assertEquals(res, exRes);
	}

}

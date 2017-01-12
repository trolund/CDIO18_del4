package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Die;

public class JUnitTestDie {

	@Test
	public void dieTest() {

		Die die1 = new Die();
		int[] terningSide = new int[7];

		for(int i = 0; i <= 10000; i++)
		{
			die1.roll();
			++terningSide[die1.getValue()];
		}
		
		int test = die1.getValue();
		boolean x = false;

		if(test >= 1 && test <= 6)
		{
			x = true;
		}

		assertEquals(x, true);
		
		for (int i = 1; i < terningSide.length; i++) 
		{
			System.out.println("Count of " + i + " eyes: " + terningSide[i]);
			assertEquals(terningSide[i], 1666, 166);
		}
	}

}


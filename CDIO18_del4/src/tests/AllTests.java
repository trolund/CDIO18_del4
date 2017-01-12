package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ChanceTest.class, JUnitTestBrewery.class, JUnitTestDie.class, JUnitTestFieldlist.class,
		JUnitTestFleet.class, JUnitTestPlayer.class, JUnitTestStartField.class, JUnitTestTax.class })
public class AllTests {

}

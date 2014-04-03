package tn.edu.esprit.infini.theWolves.tvForExClient.jUnitTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestAddCountry.class, TestFindCountry.class,
		 TestRemoveCountry.class, TestNotRemoveCountry.class })
public class AllTestsCountry {

}

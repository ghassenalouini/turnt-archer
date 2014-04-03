package tn.edu.esprit.infini.theWolves.tvForExClient.jUnitTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestAddCurrency.class,
		TestDisplayCurrency.class,
		TestFindCurrencyById.class,
		TestNotRemoveCurrency.class,
		TestNotUpdateCurrency.class,
		TestUpdateCurrency.class,
		TestRemoveCurrency.class })


public class AllTestsCurrency {

}

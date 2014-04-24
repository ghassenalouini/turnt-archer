package tn.edu.esprit.infini.theWolves.tvForExClient.jUnitTest;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.ExchangeRate;
import tn.edu.esprit.infini.theWolves.tvForEx.facadeLocal.interfaces.ExRateFacadeLocal;
import tn.edu.esprit.infini.theWolves.tvForEx.facadeRemote.interfaces.ExchangeRateFacadeRemote;

public class TestCotationCalcul {

	private ExchangeRateFacadeRemote proxy;

	@Before
	public void test() {

		try {
			Context context = new InitialContext();

			System.out.println("aaa");
			
			String jndiName = "ejb:/tn.edu.esprit.infini.theWolves.tvForEx/ExchangeRateFacade!"
					+ ExchangeRateFacadeRemote.class.getCanonicalName();

			proxy = (ExchangeRateFacadeRemote) context.lookup(jndiName);
			
			System.out.println("bbb");

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testFind() {
		ExchangeRate exchangeRate = new ExchangeRate();
		exchangeRate.setCurrencyTR("CAD");
		exchangeRate.setId(5);
		exchangeRate.setCurrency("USD");
		exchangeRate.setRate((float)1.5);
		
		Assert.assertEquals(exchangeRate,
				proxy.findExchangeRateByCurrencyRT("EUR"));

	}

}

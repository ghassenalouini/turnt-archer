package tn.edu.esprit.infini.theWolves.tvForExClient.jUnitTest;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;
import tn.edu.esprit.infini.theWolves.tvForEx.facade.interfaces.CurrencyFacadeRemote;

@SuppressWarnings("deprecation")
public class CurrencyTest {

	private CurrencyFacadeRemote proxy;

	@Before
	public void test() {

		try {
			Context context = new InitialContext();

			String jndiName = "ejb:/tn.edu.esprit.infini.theWolves.tvForEx/CurrencyFacade!"
					+ CurrencyFacadeRemote.class.getCanonicalName();

			proxy = (CurrencyFacadeRemote) context.lookup(jndiName);

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testaddCurrency() {

		Currency currency = new Currency();
		currency.setLabel("euro");
		currency.setInitials("EUR");

		Assert.assertTrue(proxy.addCurrency(currency));
	}

	@Test
	public void testFindCurrencyById() {
		
	//	Currency currency= proxy.findCurrencyById(1);
		
		
	//	Assert.assertEquals(currency,currency2);
		
	}

	@Test
	public void testRemoveCurrency() {
		Currency currency = new Currency();
		Assert.assertTrue(proxy.removeCurrency(currency));
	}

	@Test
	public void testUpdateCurrency() {
		Currency currency = new Currency();
		Assert.assertTrue(proxy.updateCurrency(currency));
	}

	@Test
	public void testDisplayCurrencies() {
		
	 //	Assert.assertTrue(proxy.findAllCurrencies());
	}

}

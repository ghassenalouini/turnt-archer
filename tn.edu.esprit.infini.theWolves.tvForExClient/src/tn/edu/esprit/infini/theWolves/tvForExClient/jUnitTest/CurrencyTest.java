package tn.edu.esprit.infini.theWolves.tvForExClient.jUnitTest;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.CurrencyServicesRemote;

public class CurrencyTest {

	private CurrencyServicesRemote proxy;

	@Before
	public void test() {

		try {
			Context context = new InitialContext();

			String jndiName = "ejb:/tn.edu.esprit.infini.theWolves.tvForEx/CurrencyServices!"
					+ CurrencyServicesRemote.class.getCanonicalName();

			proxy = (CurrencyServicesRemote) context.lookup(jndiName);

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

		System.out.println(proxy.addCurrency(currency));
	}

	@Test
	public void testFindCurrencyById() {

		Currency currency = proxy.findCurrencyById(1);
		System.out.println(currency);

	}

	@Test
	public void testRemoveCurrency() {
		Currency currency = new Currency();
		System.out.println(proxy.removeCurrency(currency));
	}

	@Test
	public void testUpdateCurrency() {
		Currency currency = new Currency();
		System.out.println(proxy.updateCurrency(currency));
	}

	@Test
	public void testDisplayCurrencies() {
		System.out.println(proxy.findAllCurrencies());
	}

}

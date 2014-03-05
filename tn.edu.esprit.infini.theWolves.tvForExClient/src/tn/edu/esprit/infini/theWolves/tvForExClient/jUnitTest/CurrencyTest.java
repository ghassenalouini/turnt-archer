package tn.edu.esprit.infini.theWolves.tvForExClient.jUnitTest;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Ignore;
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

	@Ignore
	public void itShouldAddCurrency() {

		Currency currency = new Currency();
		currency.setLabel("euro");
		currency.setInitials("EUR");

		Assert.assertTrue(proxy.addCurrency(currency));

	}

	@Ignore
	public void itShouldNotAddCurrency() throws Exception {

		Currency currency = new Currency();
		currency.setLabel("euro");
		currency.setInitials("EUR");

	}

	@Ignore
	public void itShouldFindCurrencyById() {

		Currency currency = proxy.findCurrencyById(1);

		Currency currency2 = new Currency();
		currency.setLabel("euro");
		currency.setInitials("EUR");

		Assert.assertEquals(currency, currency2);

	}

	@Ignore
	public void itShouldRemoveCurrency() {
		Currency currency = new Currency();
		Assert.assertTrue(proxy.removeCurrency(currency));
	}

	@Ignore
	public void itShouldUpdateCurrency() {
		Currency currency = new Currency();
		Assert.assertTrue(proxy.updateCurrency(currency));
	}

	@Test(expected= Exception.class)  
	public void itShouldNotDisplayCurrencies() {

		List<Currency> CurrencyList = new ArrayList<>();
		CurrencyList = proxy.findAllCurrencies();

		Assert.assertEquals(12, CurrencyList.size());

	}

}

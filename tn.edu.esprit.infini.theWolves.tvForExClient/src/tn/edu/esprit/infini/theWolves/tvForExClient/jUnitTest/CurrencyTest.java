package tn.edu.esprit.infini.theWolves.tvForExClient.jUnitTest;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import junit.framework.Assert;
import junit.framework.AssertionFailedError;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;
import tn.edu.esprit.infini.theWolves.tvForEx.facade.interfaces.CurrencyFacadeRemote;

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
	@Test
	public void itShouldAddCurrency() {

		Currency currency = new Currency();
		currency.setLabel("euro");
		currency.setInitials("EUR");

		Assert.assertTrue(proxy.addCurrency(currency));

	}

	@Ignore
	@Test
	public void itShouldFindCurrencyById() {
		Currency currency = proxy.findCurrencyById(3);

		Assert.assertEquals("euro", currency.getLabel());

	}

	@Ignore
	@Test(expected = NullPointerException.class)
	public void itShouldNotFindCurrencyById() {
		Currency currency = proxy.findCurrencyById(1);

		Assert.assertEquals("euro", currency.getLabel());

	}

	@Ignore
	@Test
	public void itShouldFindCurrencyByIdAndCompareIt() {

		Currency currency = proxy.findCurrencyById(2);

		Currency currency2 = new Currency();
		currency2.setLabel("euro");
		currency2.setInitials("EUR");

		Assert.assertEquals(currency.getLabel(), currency2.getLabel());

	}

	@Ignore
	@Test(expected = junit.framework.ComparisonFailure.class)
	public void itShouldFindCurrencyByIdAndCompareIt2() {

		Currency currency = proxy.findCurrencyById(2);

		Currency currency2 = new Currency();
		currency2.setLabel("eurooooo");
		currency2.setInitials("EUR");

		Assert.assertEquals(currency.getLabel(), currency2.getLabel());

	}

	@Ignore
	@Test
	public void itShouldRemoveCurrency() {
		Assert.assertTrue(proxy.removeCurrency(proxy.findCurrencyById(2)));
	}

	@Ignore
	@Test(expected = AssertionFailedError.class)
	public void itShouldNotRemoveCurrency() {
		Assert.assertTrue(proxy.removeCurrency(proxy.findCurrencyById(1)));
	}

	@Ignore
	@Test
	public void itShouldUpdateCurrency() {
		Currency currency = proxy.findCurrencyById(1);
		currency.setInitials("aaaaaaaaaaa");
		Assert.assertTrue(proxy.updateCurrency(currency));
	}

	@Ignore
	@Test(expected = NullPointerException.class)
	public void itShouldNotUpdateCurrency() {
		Currency currency = proxy.findCurrencyById(1);
		currency.setInitials("aaaaaaaaaaa");
		Assert.assertTrue(proxy.updateCurrency(currency));
	}

	@Ignore
	@Test
	public void itShouldDisplayCurrencies() {

		List<Currency> CurrencyList = new ArrayList<Currency>();
		CurrencyList = proxy.findAllCurrencies();

		Assert.assertEquals(1, CurrencyList.size());

	}

	@Ignore
	@Test(expected = AssertionFailedError.class)
	public void itShouldNotDisplayCurrencies() {

		List<Currency> CurrencyList = new ArrayList<Currency>();
		CurrencyList = proxy.findAllCurrencies();

		Assert.assertEquals(10, CurrencyList.size());

	}

}

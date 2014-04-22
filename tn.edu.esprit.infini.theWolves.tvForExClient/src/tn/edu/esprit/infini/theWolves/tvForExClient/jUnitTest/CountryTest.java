package tn.edu.esprit.infini.theWolves.tvForExClient.jUnitTest;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import junit.framework.Assert;
import junit.framework.AssertionFailedError;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Country;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;
import tn.edu.esprit.infini.theWolves.tvForEx.facadeRemote.interfaces.CountryFacadeRemote;

public class CountryTest {
	private CountryFacadeRemote proxy;

	@Before
	public void test() {
		try {
			Context context = new InitialContext();
			String jndiName = "ejb:/tn.edu.esprit.infini.theWolves.tvForEx/CountryFacade!"
					+ CountryFacadeRemote.class.getCanonicalName();
			proxy = (CountryFacadeRemote) context.lookup(jndiName);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Ignore
	@Test
	public void itShouldAdd() {
		Currency cr = new Currency("dollar", 1, "USD");
		cr.setId(1);
		Country country = new Country("Tunisie", "TN");

		Assert.assertTrue(proxy.addCountry(country));

	}

	@Ignore
	@Test
	public void itShouldFindCountry() {
		Country ctr = (Country) proxy.findCountryById(2);

		Assert.assertEquals("Tunisie", ctr.getName());

	}

	@Ignore
	@Test(expected = NullPointerException.class)
	public void itShouldNotFindCountry() {
		Country ctr = (Country) proxy.findCountryById(6);

		Assert.assertEquals("Tsie", ctr.getName());

	}

	@Ignore
	@Test
	public void itShouldRemoveCountry() {
		Country ctr = (Country) proxy.findCountryById(2);
		Assert.assertTrue(proxy.removeCountry(ctr));
	}

	@Test(expected = AssertionFailedError.class)
	public void itShouldNotRemoveCountry() {
		Country ctr = (Country) proxy.findCountryById(2);
		Assert.assertTrue(proxy.removeCountry(ctr));
	}

}

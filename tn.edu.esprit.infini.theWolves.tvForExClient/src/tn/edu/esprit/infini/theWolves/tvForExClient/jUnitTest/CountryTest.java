package tn.edu.esprit.infini.theWolves.tvForExClient.jUnitTest;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Country;
import tn.edu.esprit.infini.theWolves.tvForEx.facade.interfaces.CountryFacadeRemote;

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

	@Test
	public void itShouldAdd() {
		Country country = new Country();
		country.setName("Tunisie");
		country.setCode("Tun");
		Assert.assertTrue(proxy.addCountry(country));

	}

}

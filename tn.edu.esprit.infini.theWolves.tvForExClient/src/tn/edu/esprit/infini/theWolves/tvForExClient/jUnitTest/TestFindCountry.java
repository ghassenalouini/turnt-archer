package tn.edu.esprit.infini.theWolves.tvForExClient.jUnitTest;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Country;
import tn.edu.esprit.infini.theWolves.tvForEx.facadeRemote.interfaces.CountryFacadeRemote;

public class TestFindCountry {
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
	public void itShouldFindCountry() {
		Country ctr = (Country) proxy.findCountryById(1);

		Assert.assertEquals("Tunisie", ctr.getName());

	}

}

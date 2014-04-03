package tn.edu.esprit.infini.theWolves.tvForExClient.jUnitTest;

import static org.junit.Assert.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Country;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;
import tn.edu.esprit.infini.theWolves.tvForEx.facade.interfaces.CountryFacadeRemote;

public class TestAddCountry {

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
		Currency cr = new Currency("dollar", 1, "USD");
		cr.setId(1);
		Country country = new Country("Tunisie", "TN");

		Assert.assertTrue(proxy.addCountry(country));

	}



}

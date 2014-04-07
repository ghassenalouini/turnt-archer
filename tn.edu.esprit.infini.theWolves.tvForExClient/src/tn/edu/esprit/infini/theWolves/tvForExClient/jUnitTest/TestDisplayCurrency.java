package tn.edu.esprit.infini.theWolves.tvForExClient.jUnitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;
import tn.edu.esprit.infini.theWolves.tvForEx.facade.interfaces.CurrencyFacadeRemote;

@SuppressWarnings({ "unused", "deprecation" })
public class TestDisplayCurrency {

	
	
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
	public void itShouldDisplayCurrencies() {

		List<Currency> CurrencyList = new ArrayList<Currency>();
		CurrencyList = proxy.findAllCurrencies();

		Assert.assertEquals(3, CurrencyList.size());

	}

}

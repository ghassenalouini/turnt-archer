package tn.edu.esprit.infini.theWolves.tvForExClient;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Bank;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.CurrencyServicesRemote;

public class TestRealPlatform {

	private Context context;
	private CurrencyServicesRemote proxy;

	@Before
	public void init() {
		try {
			context = new InitialContext();
			proxy = (CurrencyServicesRemote) context
					.lookup("ejb:/tn.edu.esprit.infini.theWolves.tvForEx/CurrencyServices!"
							+ CurrencyServicesRemote.class.getCanonicalName());
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void itShouldAddCrossTransaction() {
		Bank bankBid = (Bank) proxy.findCustomerById(1);
		Bank bank = (Bank) proxy.findCustomerById(2);
		Currency currency = proxy.findCurrencyById(1);
		Currency currencyCross = proxy.findCurrencyById(2);

		Assert.assertTrue(proxy.addCrossTransaction(bank, bankBid, currency,
				currencyCross, "buy", 2000, 2.00F, 1.2F));

	}

}

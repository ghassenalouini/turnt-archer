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
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.CustomerServicesRemote;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.TransactionServicesRemote;

@SuppressWarnings("deprecation")
public class TestRealPlatform {

	private Context context;
	private CurrencyServicesRemote proxy;
	private CustomerServicesRemote proxyCust;
	private TransactionServicesRemote proxyTr;

	@Before
	public void init() {
		try {
			context = new InitialContext();

			proxy = (CurrencyServicesRemote) context
					.lookup("ejb:/tn.edu.esprit.infini.theWolves.tvForEx/CurrencyServices!"
							+ CurrencyServicesRemote.class.getCanonicalName());

			String jndiNameCust = "ejb:/tn.edu.esprit.infini.theWolves.tvForEx/CustomerServices!"
					+ CustomerServicesRemote.class.getCanonicalName();
			proxyCust = (CustomerServicesRemote) context.lookup(jndiNameCust);

			String jndiNameTr = "ejb:/tn.edu.esprit.infini.theWolves.tvForEx/TransactionServices!"
					+ TransactionServicesRemote.class.getCanonicalName();
			proxyTr = (TransactionServicesRemote) context.lookup(jndiNameTr);

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	@Test
	public void itShouldAddCrossTransaction() {
		
		Bank bankBid = (Bank) proxyCust.findCustomerById(1);
		Bank bank = (Bank) proxyCust.findCustomerById(2);
		Currency currency = proxy.findCurrencyById(1);
		Currency currencyCross = proxy.findCurrencyById(2);


		Assert.assertTrue(proxyTr.addCrossTransaction(bank, bankBid, currency, currencyCross, "buy", 2000, 2.00F, 1.2F));
	}

}

package tn.edu.esprit.infini.theWolves.tvForExClient.jUnitTest;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Bank;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Customer;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.CurrencyServicesRemote;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.CustomerServicesRemote;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.TransactionServicesRemote;

public class TransactionTest {

	private TransactionServicesRemote proxy;
	private CurrencyServicesRemote proxyCu;
	private CustomerServicesRemote proxyCust;

	@Before
	public void test() {

		try {
			Context context = new InitialContext();

			String jndiName = "ejb:/tn.edu.esprit.infini.theWolves.tvForEx/TransactionServices!"
					+ TransactionServicesRemote.class.getCanonicalName();
			String jndiNameCu = "ejb:/tn.edu.esprit.infini.theWolves.tvForEx/CurrencyServices!"
					+ CurrencyServicesRemote.class.getCanonicalName();
			String jndiNameCust = "ejb:/tn.edu.esprit.infini.theWolves.tvForEx/CustomerServices!"
					+ CustomerServicesRemote.class.getCanonicalName();

			proxy = (TransactionServicesRemote) context.lookup(jndiName);
			proxyCu = (CurrencyServicesRemote) context.lookup(jndiNameCu);
			proxyCust = (CustomerServicesRemote) context.lookup(jndiNameCust);

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testaddTransactionAndTranscationCross() {

		Customer customerBid = proxyCust.findCustomerById(2);
		Customer customer = proxyCust.findCustomerById(1);
		Currency currency = proxyCu.findCurrencyById(1);
		Currency currencyCross = proxyCu.findCurrencyById(2);

		Customer customerBid2 = proxyCust.findCustomerById(1);
		Customer customer2 = proxyCust.findCustomerById(4);
		Currency currency2 = proxyCu.findCurrencyById(5);
		Currency currencyCross2 = proxyCu.findCurrencyById(6);

		proxy.addCrossTransaction(customer2, customerBid2, currency2,
				currencyCross2, "buy", 500, 3.00F, 9.00F);

		proxy.addCrossTransaction(customer, customerBid, currency,
				currencyCross, "buy", 200, 2.10F, 17.0F);

		System.out.println(proxy.addCrossTransaction(customer2, customerBid2,
				currency2, currencyCross2, "buy", 500, 3.00F, 9.00F));

		System.out.println(proxy.addTransaction(customer, currency, "sell",
				1000, 2.2F));

	}

	@Test
	public void testCreateOffer() {

		Customer bank = proxyCust.findCustomerById(1);
		Currency currency = proxyCu.findCurrencyById(1);

		System.out.println(proxy.createOffer((Bank) bank, currency, 2.2F));

	}

}

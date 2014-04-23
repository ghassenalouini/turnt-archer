package tn.edu.esprit.infini.theWolves.tvForExClient;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Bank;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;
import tn.edu.esprit.infini.theWolves.tvForEx.facadeRemote.interfaces.CurrencyFacadeRemote;
import tn.edu.esprit.infini.theWolves.tvForEx.facadeRemote.interfaces.CustomerFacadeRemote;
import tn.edu.esprit.infini.theWolves.tvForEx.facadeRemote.interfaces.TransactionFacadeRemote;

@SuppressWarnings("deprecation")
public class TestRealPlatform {

	private Context context;
	private CurrencyFacadeRemote proxy;
	private CustomerFacadeRemote proxyCust;
	private TransactionFacadeRemote proxyTr;

	@Before
	public void init() {
		try {
			context = new InitialContext();

			proxy = (CurrencyFacadeRemote) context
					.lookup("ejb:/tn.edu.esprit.infini.theWolves.tvForEx/CurrencyFacade!"
							+ CurrencyFacadeRemote.class.getCanonicalName());

			String jndiNameCust = "ejb:/tn.edu.esprit.infini.theWolves.tvForEx/CustomerFacade!"
					+ CustomerFacadeRemote.class.getCanonicalName();
			proxyCust = (CustomerFacadeRemote) context.lookup(jndiNameCust);

			String jndiNameTr = "ejb:/tn.edu.esprit.infini.theWolves.tvForEx/TransactionFacade!"
					+ TransactionFacadeRemote.class.getCanonicalName();
			proxyTr = (TransactionFacadeRemote) context.lookup(jndiNameTr);

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void itShouldAddCrossTransaction() {

		Bank bankBid = (Bank) proxyCust.findCustomerById(1);
		Bank bank = (Bank) proxyCust.findCustomerById(2);
		Currency currency = proxy.findCurrencyByLabbel("USD");
		Currency currencyCross = proxy.findCurrencyByLabbel("USD");

	}

}

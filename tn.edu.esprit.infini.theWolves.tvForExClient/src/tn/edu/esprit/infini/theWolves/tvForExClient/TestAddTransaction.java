package tn.edu.esprit.infini.theWolves.tvForExClient;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Customer;
import tn.edu.esprit.infini.theWolves.tvForEx.facadeRemote.interfaces.CurrencyFacadeRemote;
import tn.edu.esprit.infini.theWolves.tvForEx.facadeRemote.interfaces.CustomerFacadeRemote;
import tn.edu.esprit.infini.theWolves.tvForEx.facadeRemote.interfaces.TransactionFacadeRemote;

public class TestAddTransaction {

	public static void main(String[] args) {
		try {
			Context context = new InitialContext();

			String jndiName = "ejb:/tn.edu.esprit.infini.theWolves.tvForEx/TransactionFacade!"
					+ TransactionFacadeRemote.class.getCanonicalName();
			TransactionFacadeRemote proxy = (TransactionFacadeRemote) context
					.lookup(jndiName);

			String jndiNameCust = "ejb:/tn.edu.esprit.infini.theWolves.tvForEx/CustomerFacade!"
					+ CustomerFacadeRemote.class.getCanonicalName();
			CustomerFacadeRemote proxyCust = (CustomerFacadeRemote) context
					.lookup(jndiNameCust);

			String jndiNameCu = "ejb:/tn.edu.esprit.infini.theWolves.tvForEx/CurrencyFacade!"
					+ CurrencyFacadeRemote.class.getCanonicalName();
			CurrencyFacadeRemote proxyCu = (CurrencyFacadeRemote) context
					.lookup(jndiNameCu);

			Customer customerBid = proxyCust.findCustomerById(2);
			Customer customer = proxyCust.findCustomerById(4);
			Currency currency = proxyCu.findCurrencyByLabbel("USD");
			Currency currencyCross = proxyCu.findCurrencyByLabbel("USD");

			Customer customerBid2 = proxyCust.findCustomerById(3);
			Customer customer2 = proxyCust.findCustomerById(4);
			Currency currency2 = proxyCu.findCurrencyByLabbel("USD");
			Currency currencyCross2 = proxyCu.findCurrencyByLabbel("USD");

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

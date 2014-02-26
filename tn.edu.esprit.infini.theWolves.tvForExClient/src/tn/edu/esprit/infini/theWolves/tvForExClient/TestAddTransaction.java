package tn.edu.esprit.infini.theWolves.tvForExClient;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Customer;
import tn.edu.esprit.infini.theWolves.tvForEx.services.impl.CurrencyServices;
import tn.edu.esprit.infini.theWolves.tvForEx.services.impl.CustomerServices;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.CurrencyServicesRemote;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.CustomerServicesRemote;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.TransactionServicesRemote;

public class TestAddTransaction {

	public static void main(String[] args) {
		try {
			Context context = new InitialContext();

			String jndiName = "ejb:/tn.edu.esprit.infini.theWolves.tvForEx/TransactionServices!"
					+ TransactionServicesRemote.class.getCanonicalName();
			TransactionServicesRemote proxy = (TransactionServicesRemote) context
					.lookup(jndiName);
			
			String jndiNameCust = "ejb:/tn.edu.esprit.infini.theWolves.tvForEx/CustomerServices!"
					+ CustomerServicesRemote.class.getCanonicalName();
			CustomerServicesRemote proxyCust = (CustomerServicesRemote) context
					.lookup(jndiNameCust);
			
			String jndiNameCu = "ejb:/tn.edu.esprit.infini.theWolves.tvForEx/CurrencyServices!"
					+ CurrencyServicesRemote.class.getCanonicalName();
			CurrencyServicesRemote proxyCu = (CurrencyServicesRemote) context
					.lookup(jndiNameCu);

			

			Customer customerBid = proxyCust.findCustomerById(2);
			Customer customer = proxyCust.findCustomerById(1);
			Currency currency = proxyCu.findCurrencyById(1);
			Currency currencyCross = proxyCu.findCurrencyById(2);

			proxy.addCrossTransaction(customer, customerBid, currency,
					currencyCross, "buy", 200, 2.10F, 17.0F);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

package tn.edu.esprit.infini.theWolves.tvForExClient;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Customer;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.CurrencyServicesRemote;

public class TestAddTransaction {

	public static void main(String[] args) {
		try {
			Context context = new InitialContext();

			String jndiName = "ejb:/tn.edu.esprit.infini.theWolves.tvForEx/CurrencyServices!"
					+ CurrencyServicesRemote.class.getCanonicalName();
			CurrencyServicesRemote proxy = (CurrencyServicesRemote) context
					.lookup(jndiName);

			Customer customerBid = proxy.findCustomerById(2);
			Customer customer = proxy.findCustomerById(1);
			Currency currency = proxy.findCurrencyById(1);
			Currency currencyCross = proxy.findCurrencyById(2);

			Customer customerBid2 = proxy.findCustomerById(1);
			Customer customer2 = proxy.findCustomerById(4);
			Currency currency2 = proxy.findCurrencyById(5);
			Currency currencyCross2 = proxy.findCurrencyById(6);

			// proxy.addCrossTransaction(customer2, customerBid2, currency2,
			// currencyCross2, "buy", 500, 3.00F, 9.00F);

			proxy.addCrossTransaction(customer, customerBid, currency,
					currencyCross, "buy", 200, 2.10F, 17.0F);
		Customer cu=proxy.findCustomerById(1);
		if(cu==null)
			System.out.println("trouvé");
		else System.out.println("non");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

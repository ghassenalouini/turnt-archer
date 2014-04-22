package tn.edu.esprit.infini.theWolves.tvForExClient;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Bank;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Customer;
import tn.edu.esprit.infini.theWolves.tvForEx.facadeRemote.interfaces.CurrencyFacadeRemote;
import tn.edu.esprit.infini.theWolves.tvForEx.facadeRemote.interfaces.CustomerFacadeRemote;
import tn.edu.esprit.infini.theWolves.tvForEx.facadeRemote.interfaces.TransactionFacadeRemote;

public class TestAddOffer {

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

			Customer bank = proxyCust.findCustomerById(2);

			Currency currency = proxyCu.findCurrencyById(2);

			boolean a = true;
			if (a == true) {
				System.err.println("Temchi");
			} else {
				System.err.println("Metemchich");
			}

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

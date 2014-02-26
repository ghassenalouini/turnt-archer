package tn.edu.esprit.infini.theWolves.tvForExClient;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Bank;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Position;
import tn.edu.esprit.infini.theWolves.tvForEx.services.impl.CurrencyServices;
import tn.edu.esprit.infini.theWolves.tvForEx.services.impl.CustomerServices;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.CurrencyServicesRemote;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.CustomerServicesRemote;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.PositionServicesRemote;

public class TestFindPositionByBankCurrency {

	public static void main(String[] args) {
		try {
			Context context = new InitialContext();

			String jndiName = "ejb:/tn.edu.esprit.infini.theWolves.tvForEx/PositionServices!"
					+ PositionServicesRemote.class.getCanonicalName();
			PositionServicesRemote proxy = (PositionServicesRemote) context
					.lookup(jndiName);

			String jndiNameCust = "ejb:/tn.edu.esprit.infini.theWolves.tvForEx/CustomerServices!"
					+ CustomerServicesRemote.class.getCanonicalName();
			CustomerServicesRemote proxyCust = (CustomerServicesRemote) context
					.lookup(jndiNameCust);
			
			String jndiNameCu = "ejb:/tn.edu.esprit.infini.theWolves.tvForEx/CurrencyServices!"
					+ CurrencyServicesRemote.class.getCanonicalName();
			CurrencyServicesRemote proxyCu = (CurrencyServicesRemote) context
					.lookup(jndiNameCu);


			Bank bank = (Bank) proxyCust.findCustomerById(1);
			Currency currency = proxyCu.findCurrencyById(1);
			Position position = proxy
					.findPositionByBankCurrency(bank, currency);

			System.out.println(position.getId());

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

package tn.edu.esprit.infini.theWolves.tvForExClient;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Bank;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Customer;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Position;
import tn.edu.esprit.infini.theWolves.tvForEx.facadeRemote.interfaces.CurrencyFacadeRemote;
import tn.edu.esprit.infini.theWolves.tvForEx.facadeRemote.interfaces.CustomerFacadeRemote;
import tn.edu.esprit.infini.theWolves.tvForEx.facadeRemote.interfaces.PositionFacadeRemote;

public class TestFindPositionByBankCurrency {

	public static void main(String[] args) {
		try {
			Context context = new InitialContext();

			String jndiName = "ejb:/tn.edu.esprit.infini.theWolves.tvForEx/PositionFacade!"
					+ PositionFacadeRemote.class.getCanonicalName();
			PositionFacadeRemote proxy = (PositionFacadeRemote) context
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
			Currency currency = proxyCu.findCurrencyByLabbel("USD");
			Position position = proxy.findPositionByBankCurrency((Bank) bank,
					currency);

			System.out.println(position.getId());

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

package tn.edu.esprit.infini.theWolves.tvForExClient;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;
import tn.edu.esprit.infini.theWolves.tvForEx.facade.interfaces.CurrencyFacadeRemote;

public class TestAddlCurrency {

	public static void main(String[] args) {
		
		try {
			Context context = new InitialContext();

			String jndiName = "TV-ForEx/tn.edu.esprit.infini.theWolves.tvForEx/CurrencyFacade!"
					+ CurrencyFacadeRemote.class.getCanonicalName();
			CurrencyFacadeRemote proxy = (CurrencyFacadeRemote) context
					.lookup(jndiName);

			Currency currency = new Currency();
			currency.setLabel("Canadien Dollar");
			currency.setInitials("CND");
			currency.setUnity(145);

			System.out.println(proxy.addCurrency(currency));
			
			
			Currency currency2=proxy.findCurrencyById(1);
			System.out.println(proxy.removeCurrency(currency2));
			

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

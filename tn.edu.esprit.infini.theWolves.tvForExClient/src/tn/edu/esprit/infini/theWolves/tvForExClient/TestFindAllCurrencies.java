package tn.edu.esprit.infini.theWolves.tvForExClient;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;
import tn.edu.esprit.infini.theWolves.tvForEx.facade.interfaces.CurrencyFacadeRemote;

public class TestFindAllCurrencies {

	public static void main(String[] args) {
		try {
			Context context = new InitialContext();

			String jndiName = "ejb:/tn.edu.esprit.infini.theWolves.tvForEx/CurrencyFacade!"
					+ CurrencyFacadeRemote.class.getCanonicalName();
			CurrencyFacadeRemote proxy = (CurrencyFacadeRemote) context
					.lookup(jndiName);

			List<Currency> currencies = proxy.findAllCurrencies();
			if (currencies != null) {
				for (Currency c : currencies) {
					System.out.println(c.getInitials() + ":");
				}
			} else {
				System.err.println("error find currencies...");

			}

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

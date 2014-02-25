package tn.edu.esprit.infini.theWolves.tvForExClient;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Bank;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.CurrencyServicesRemote;

public class TestInitPlatform {

	public static void main(String[] args) {
		try {
			Context context = new InitialContext();

			String jndiName = "ejb:/tn.edu.esprit.infini.theWolves.tvForEx/CurrencyServices!"
					+ CurrencyServicesRemote.class.getCanonicalName();
			CurrencyServicesRemote proxy = (CurrencyServicesRemote) context
					.lookup(jndiName);

			Currency currency = new Currency();
			currency.setLabel("euro");
			currency.setInitials("EUR");

			Currency currency2 = new Currency();
			currency2.setLabel("franc suisse");
			currency2.setInitials("CHF");

			Currency currency3 = new Currency();
			currency3.setLabel("dinar tunisien");
			currency3.setInitials("TND");

			Bank bank = new Bank();
			bank.setName("bk1");
			bank.setAdresse_mail("Tunis");
			bank.setFond_propre(4000);
			bank.setLogin("BK" + bank.getName() + bank.getId());
			bank.setPassword("bk1");
			bank.setSwift_code("SHMP2565");

			Bank bank2 = new Bank();
			bank2.setName("bk2");
			bank2.setAdresse_mail("Sousse");
			bank2.setFond_propre(50000);
			bank2.setLogin("BK" + bank2.getName() + bank2.getId());
			bank2.setPassword("bk1");
			bank2.setSwift_code("SHMP2565");

			proxy.addCurrency(currency);
			proxy.addCurrency(currency2);
			proxy.addCurrency(currency3);
			proxy.addBank(bank);
			proxy.addBank(bank2);

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

package tn.edu.esprit.infini.theWolves.tvForExClient.jUnitTest;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Bank;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Corporate;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;
import tn.edu.esprit.infini.theWolves.tvForEx.facade.interfaces.CurrencyFacadeRemote;
import tn.edu.esprit.infini.theWolves.tvForEx.facade.interfaces.CustomerFacadeRemote;

public class initPlatformTest {

	private CurrencyFacadeRemote proxy;
	private CustomerFacadeRemote proxy2;

	@Before
	public void test() {
		try {
			Context context = new InitialContext();

			String jndiName = "ejb:/tn.edu.esprit.infini.theWolves.tvForEx/CurrencyFacade!"
					+ CurrencyFacadeRemote.class.getCanonicalName();
			proxy = (CurrencyFacadeRemote) context.lookup(jndiName);

			String jndiName2 = "ejb:/tn.edu.esprit.infini.theWolves.tvForEx/CustomerFacade!"
					+ CustomerFacadeRemote.class.getCanonicalName();
			proxy2 = (CustomerFacadeRemote) context.lookup(jndiName2);

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void TestPlatform() {

		Currency currency = new Currency();
		currency.setLabel("euro");
		currency.setInitials("EUR");
		currency.setUnity(1);

		Currency currency2 = new Currency();
		currency2.setLabel("franc suisse");
		currency2.setInitials("CHF");
		currency2.setUnity(10);

		Currency currency3 = new Currency();
		currency3.setLabel("dinar tunisien");
		currency3.setInitials("TND");
		currency3.setUnity(1);

		Currency currency4 = new Currency("Dollar Australien", 1, "AUD");

		Currency currency5 = new Currency("Dollar Canadien", 1, "CUD");

		Currency currency6 = new Currency("Yen Japponais", 10, "JPY");

		Currency currency7 = new Currency("Yuan chinois ", 1, "CNY");

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
		proxy.addCurrency(currency4);
		proxy.addCurrency(currency5);
		proxy.addCurrency(currency6);
		proxy.addCurrency(currency7);

		proxy2.addCustomer(bank);
		proxy2.addCustomer(bank2);

		Corporate corporate = new Corporate();
		corporate.setName("Ali");
		corporate.setAdresse_mail("Ali@iagiub.ti");
		corporate.setTypeActivity("seller");
		corporate.setLogin("login");
		corporate.setPassword("password");

		Corporate corporate2 = new Corporate();
		corporate2.setName("Anis");
		corporate2.setAdresse_mail("Anis@fgr.tn");
		corporate2.setTypeActivity("Importator");
		corporate2.setLogin("login");
		corporate2.setPassword("password");

		proxy2.addCustomer(corporate2);
		proxy2.addCustomer(corporate);

	}
}

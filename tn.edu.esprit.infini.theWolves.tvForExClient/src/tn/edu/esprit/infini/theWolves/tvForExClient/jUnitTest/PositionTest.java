package tn.edu.esprit.infini.theWolves.tvForExClient.jUnitTest;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


import org.junit.Before;
import org.junit.Test;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Bank;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Position;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.CurrencyServicesRemote;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.CustomerServicesRemote;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.PositionServicesRemote;

public class PositionTest {

	private PositionServicesRemote proxy;
	private CurrencyServicesRemote proxyCu;
	private CustomerServicesRemote proxyCust;
	
	
	@Before
	public void test() {

		try {
			Context context = new InitialContext();

			String jndiName = "ejb:/tn.edu.esprit.infini.theWolves.tvForEx/PositionServices!"
					+ PositionServicesRemote.class.getCanonicalName();
			String jndiNameCu = "ejb:/tn.edu.esprit.infini.theWolves.tvForEx/CurrencyServices!"
					+ CurrencyServicesRemote.class.getCanonicalName();
			String jndiNameCust = "ejb:/tn.edu.esprit.infini.theWolves.tvForEx/CustomerServices!"
					+ CustomerServicesRemote.class.getCanonicalName();

			proxy = (PositionServicesRemote) context.lookup(jndiName);
			proxyCu = (CurrencyServicesRemote) context.lookup(jndiNameCu);
			proxyCust = (CustomerServicesRemote) context.lookup(jndiNameCust);

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	@Test
	public void testUpdatePosition() {

		
		// System.out.println(proxy.updatePosition(transaction));
		
	}

	
	@Test
	public void testfindPostionbyBankCuurency() {

		Bank bank = (Bank) proxyCust.findCustomerById(1);
		Currency currency = proxyCu.findCurrencyById(1);
		
		Position position = proxy.findPositionByBankCurrency(bank, currency);

		System.out.println(position.getId());
		
	}
	
	
}

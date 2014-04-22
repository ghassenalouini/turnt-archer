package tn.edu.esprit.infini.theWolves.tvForExClient.jUnitTest;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Bank;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Position;
import tn.edu.esprit.infini.theWolves.tvForEx.facadeRemote.interfaces.CurrencyFacadeRemote;
import tn.edu.esprit.infini.theWolves.tvForEx.facadeRemote.interfaces.CustomerFacadeRemote;
import tn.edu.esprit.infini.theWolves.tvForEx.facadeRemote.interfaces.PositionFacadeRemote;

public class PositionTest {

	private PositionFacadeRemote proxy;
	private CurrencyFacadeRemote proxyCu;
	private CustomerFacadeRemote proxyCust;

	@Before
	public void test() {

		try {
			Context context = new InitialContext();

			String jndiName = "ejb:/tn.edu.esprit.infini.theWolves.tvForEx/PositionFacade!"
					+ PositionFacadeRemote.class.getCanonicalName();
			String jndiNameCu = "ejb:/tn.edu.esprit.infini.theWolves.tvForEx/CurrencyFacade!"
					+ CurrencyFacadeRemote.class.getCanonicalName();
			String jndiNameCust = "ejb:/tn.edu.esprit.infini.theWolves.tvForEx/CustomerFacade!"
					+ CustomerFacadeRemote.class.getCanonicalName();

			proxy = (PositionFacadeRemote) context.lookup(jndiName);
			proxyCu = (CurrencyFacadeRemote) context.lookup(jndiNameCu);
			proxyCust = (CustomerFacadeRemote) context.lookup(jndiNameCust);

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

package tn.edu.esprit.infini.theWolves.tvForExClient.jUnitTest;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Trader;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.TraderServicesRemote;

public class TraderTest {

	private TraderServicesRemote proxy;

	@Before
	public void test() {

		try {
			Context context = new InitialContext();

			String jndiName = "ejb:/tn.edu.esprit.infini.theWolves.tvForEx/TraderServices!"
					+ TraderServicesRemote.class.getCanonicalName();

			proxy = (TraderServicesRemote) context.lookup(jndiName);

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testaddTrader() {

		Trader trader = new Trader();

		trader.setId(1);
		trader.setLogin("abc");
		trader.setPswd("abc");
		trader.setName("trader 1");

		proxy.addTrader(trader);
		
	}

	@Test
	public void testFindTraderById() {

		Trader trader = proxy.findTraderbyId(1);
		System.out.println(trader);

	}

	@Test
	public void testRemoveTrader() {
		Trader trader = new Trader();
		proxy.removeCustomer(trader);
	}

	@Test
	public void testUpdateTrader() {
		Trader trader = new Trader();
		proxy.updateTrader(trader);
	}

	@Test
	public void testDisplayTraders() {
		proxy.findAllTraders();
	}
}

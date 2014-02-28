package tn.edu.esprit.infini.theWolves.tvForExClient.jUnitTest;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Bank;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Corporate;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Customer;
import tn.edu.esprit.infini.theWolves.tvForEx.facade.interfaces.CustomerFacadeRemote;

public class CustomerTest {

	private CustomerFacadeRemote proxy;

	@Before
	public void test() {

		try {
			Context context = new InitialContext();

			String jndiName = "ejb:/tn.edu.esprit.infini.theWolves.tvForEx/CustomerFacade!"
					+ CustomerFacadeRemote.class.getCanonicalName();

			proxy = (CustomerFacadeRemote) context.lookup(jndiName);

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testaddCustomer() {

		Bank bank = new Bank("bank1", "a", "b", 334444, "aee@ea.com", 120000,
				"BK23");
		Corporate corporate = new Corporate("corp", "aa", "bb", 988,
				"corp@corp.tn", "financial");

		proxy.addCustomer(corporate);
		proxy.addCustomer(bank);

	}

	@Test
	public void testFindCustomerById() {

		Customer customer = proxy.findCustomerById(1);
		System.out.println(customer);

	}

	@Test
	public void testRemoveCustomer() {
		Customer customer = new Customer();
		proxy.removeCustomer(customer);
	}

	@Test
	public void testUpdateCustomer() {
		Customer customer = new Customer();
		proxy.updateCustomer(customer);
	}

	@Test
	public void testDisplayCustomers() {
		proxy.findAllCustomers();
	}
}

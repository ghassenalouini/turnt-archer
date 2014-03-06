package tn.edu.esprit.infini.theWolves.tvForExClient.jUnitTest;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import junit.framework.Assert;
import junit.framework.AssertionFailedError;
import junit.framework.ComparisonFailure;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Bank;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Customer;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Trader;
import tn.edu.esprit.infini.theWolves.tvForEx.facade.interfaces.CustomerFacadeRemote;

@SuppressWarnings("deprecation")
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
	public void itShouldAddCustomer() {

		// Customer customer = new Customer("bank1", "a", "b", 334444,
		// "aee@ea.com");
		Bank bank = new Bank(20000, "BKAZDAZDA");
		bank.setId(1);
		
		Trader tr = new Trader("wolves", "wolves", "wolves", 22485569,
				" wolves@esprit.tn", 0, "AdministrateurTrader", bank);
		// Assert.assertTrue(proxy.addCustomer(bank));
		Assert.assertTrue(proxy.addCustomer(tr));

	}

	@Ignore
	@Test
	public void itShouldFindCustomer() {
		Bank bank = (Bank) proxy.findCustomerById(1);

		Assert.assertEquals("BK23", bank.getSwift_code());

	}

	@Ignore
	@Test(expected = NullPointerException.class)
	public void itShouldNotFindCustomer() {
		Bank bank = (Bank) proxy.findCustomerById(3);

		Assert.assertEquals("BK23", bank.getSwift_code());

	}

	@Ignore
	@Test(expected = ComparisonFailure.class)
	public void itShouldFindCustomerByIdAndCompareIt() {

		Bank bank = (Bank) proxy.findCustomerById(1);
		Assert.assertEquals("bk25", bank.getSwift_code());

	}

	@Ignore
	@Test
	public void itShouldRemoveCustomer() {
		Bank bank = (Bank) proxy.findCustomerById(1);
		Assert.assertTrue(proxy.removeCustomer(bank));
	}

	@Ignore
	@Test(expected = AssertionFailedError.class)
	public void itShouldNotRemoveCustomer() {
		Bank bank = (Bank) proxy.findCustomerById(1);
		Assert.assertTrue(proxy.removeCustomer(bank));
	}

	@Ignore
	@Test
	public void itShouldUpdateCustomer() {
		Customer customer = proxy.findCustomerById(1);
		customer.setAdresse_mail("zert@fgh.com");
		Assert.assertTrue(proxy.updateCustomer(customer));
	}

	@Ignore
	@Test
	public void itShouldDisplayCustomer() {

		List<Customer> CustomerList = new ArrayList<Customer>();
		CustomerList = proxy.findAllCustomers();
		Assert.assertEquals(1, CustomerList.size());

	}

	@Ignore
	@Test(expected = AssertionFailedError.class)
	public void itShouldNotDisplayCustomer() {

		List<Customer> CustomerList = new ArrayList<Customer>();
		CustomerList = proxy.findAllCustomers();
		Assert.assertEquals(80, CustomerList.size());

	}
}

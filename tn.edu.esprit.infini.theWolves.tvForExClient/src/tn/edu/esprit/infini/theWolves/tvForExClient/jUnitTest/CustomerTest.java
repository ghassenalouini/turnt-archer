package tn.edu.esprit.infini.theWolves.tvForExClient.jUnitTest;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Corporate;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Customer;
import tn.edu.esprit.infini.theWolves.tvForEx.facade.interfaces.CustomerFacadeRemote;



public class CustomerTest {

	private CustomerFacadeRemote proxy; 
	
	@Before
	public void test() {
	
	try {
			Context context = new InitialContext();

			String jndiName = "ejb:/tn.edu.esprit.infini.theWolves.tvForEx/CustomerServices!"
					+ CustomerFacadeRemote.class.getCanonicalName();
			
			 proxy = (CustomerFacadeRemote) context
					.lookup(jndiName);

	} catch (NamingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
	
	@Test
	public void testaddCustomer(){
			
			Customer corporate = new Corporate();

		
			corporate.setId(1);
	    	((Corporate)corporate).setTypeActivity("seller");
			
			corporate.setLogin("login");
			corporate.setPassword("password");
			corporate.setName("corp1");
			corporate.setAdresse_mail("corp@corp.com");
			
			proxy.addCustomer(corporate);
		
	}
	
	@Test
	public void testFindCustomerById(){
		
		Customer customer= proxy.findCustomerById(1);
		System.out.println(customer);
		
	}
	
	@Test
	public void testRemoveCustomer()
	{
		Customer customer= new Customer();
		proxy.removeCustomer(customer);
	}
	
	@Test
	public void testUpdateCustomer()
	{
		Customer customer= new Customer();
		proxy.updateCustomer(customer);
	}

	@Test
	public void testDisplayCustomers()
	{
		proxy.findAllCustomers();
	}
}

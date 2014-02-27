package tn.edu.esprit.infini.theWolves.tvForExClient;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Corporate;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Customer;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.CustomerServicesRemote;

public class TestAddCustomer {

	public static void main(String[] args) {
		try {
			
			Context context = new InitialContext();

			String jndiName = "ejb:/tn.edu.esprit.infini.theWolves.tvForEx/CustomerServices!"
					+ CustomerServicesRemote.class.getCanonicalName();
			
			CustomerServicesRemote proxy = (CustomerServicesRemote) context
					.lookup(jndiName);


			Customer corporate = new Corporate();

		
			corporate.setId(1);
	    	((Corporate)corporate).setTypeActivity("seller");
			
			corporate.setLogin("login");
			corporate.setPassword("password");
			corporate.setName("corp1");
			corporate.setAdresse_mail("corp@corp.com");
			

			proxy.addCustomer(corporate);

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

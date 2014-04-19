package tn.edu.esprit.infini.theWolves.tvForExClient;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Administrator;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Bank;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Corporate;
import tn.edu.esprit.infini.theWolves.tvForEx.facade.interfaces.AdministratorFacadeLocal;
import tn.edu.esprit.infini.theWolves.tvForEx.facade.interfaces.AdministratorFacadeRemote;
import tn.edu.esprit.infini.theWolves.tvForEx.facade.interfaces.CustomerFacadeLocal;
import tn.edu.esprit.infini.theWolves.tvForEx.facade.interfaces.CustomerFacadeRemote;

public class TestAddCustomer {

	public static void main(String[] args) {
		try {

			Context context = new InitialContext();

			String jndiName = "ejb:/tn.edu.esprit.infini.theWolves.tvForEx/CustomerFacade!"
					+ CustomerFacadeRemote.class.getCanonicalName();
			String jndiName2 = "ejb:/tn.edu.esprit.infini.theWolves.tvForEx/AdministratorFacade!"
					+ AdministratorFacadeRemote.class.getCanonicalName();

			CustomerFacadeLocal proxy = (CustomerFacadeLocal) context
					.lookup(jndiName);
			AdministratorFacadeLocal proxy2 = (AdministratorFacadeLocal) context
					.lookup(jndiName2);

			Bank bank = new Bank();
			bank.setLogin("bank");
			bank.setPassword("bank");
			bank.setName("bank");
				
			Corporate corporate = new Corporate("corp", "aa", "bb", 988,
					"corp@corp.tn", "financial");

			//proxy.addCustomer(corporate);
			proxy.addCustomer(bank);
			Administrator admin = new Administrator();
			admin.setNom("Admin");
			admin.setLogin("login");
			admin.setPassword("password");
			admin.setEmailAddress("aaaa@kkkk");
			if (admin != null) {
				proxy2.addAdmin(admin);
			} else {System.out.println("no");
			}

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

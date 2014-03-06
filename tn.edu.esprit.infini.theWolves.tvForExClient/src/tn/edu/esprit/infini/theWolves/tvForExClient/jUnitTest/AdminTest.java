package tn.edu.esprit.infini.theWolves.tvForExClient.jUnitTest;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Administrator;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Rules;
import tn.edu.esprit.infini.theWolves.tvForEx.facade.interfaces.AdministratorFacadeRemote;

public class AdminTest {

	private AdministratorFacadeRemote proxy;

	@Before
	public void test() {

		try {
			Context context = new InitialContext();

			String jndiName = "ejb:/tn.edu.esprit.infini.theWolves.tvForEx/AdministratorFacade!"
					+ AdministratorFacadeRemote.class.getCanonicalName();

			proxy = (AdministratorFacadeRemote) context.lookup(jndiName);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void itShouldAddAdmin() {
		List<Rules> R = new ArrayList<Rules>();
		Administrator ad = new Administrator("ohoi", "inin", "oinin",
				"iuniunoi", R);
		Administrator admin = new Administrator();
		admin.setNom("Admin");
		admin.setLogin("login");
		admin.setPassword("password");
		admin.setEmailAddress("aaaa@kkkk");
		Assert.assertTrue(proxy.addAdmin(ad));
		
	
		/*
		 * List<Rules> rules = new ArrayList<Rules>(); Rules r1 = new Rules();
		 * Date d1 = new Date(); r1.setDate(d1); r1.setLabel("Rules num 1");
		 * r1.setValue(1F); r1.setAdministrator(admin); Rules r2 = new Rules();
		 * Date d2 = new Date(); r2.setDate(d2); r2.setLabel("Rules num 2");
		 * r2.setValue(3F); r2.setAdministrator(admin); rules.add(r2);
		 * admin.setRules(rules);
		 */

	}
}

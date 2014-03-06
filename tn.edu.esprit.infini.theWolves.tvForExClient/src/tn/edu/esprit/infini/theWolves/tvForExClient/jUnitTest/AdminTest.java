package tn.edu.esprit.infini.theWolves.tvForExClient.jUnitTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import junit.framework.Assert;
import junit.framework.AssertionFailedError;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Administrator;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;
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

	@Ignore
	@Test
	public void itShouldAddAdmin() {
		Administrator admin = new Administrator();
		admin.setNom("Admin");
		admin.setLogin("login");
		admin.setPassword("password");
		admin.setEmailAddress("aaaa@kkkk");

		List<Rules> rules = new ArrayList<Rules>();
		Rules r1 = new Rules();
		Date d1 = new Date();
		r1.setDate(d1);
		r1.setLabel("Rules num 1");
		r1.setValue(1F);
		r1.setAdministrator(admin);
		rules.add(r1);
		Rules r2 = new Rules();
		Date d2 = new Date();
		r2.setDate(d2);
		r2.setLabel("Rules num 2");
		r2.setValue(3F);
		r2.setAdministrator(admin);
		rules.add(r2);
		admin.setRules(rules);

		Assert.assertTrue(proxy.addAdmin(admin));

	}

	@Ignore
	@Test
	public void itShouldFindAdminById() {
		Administrator admin = proxy.findAdminById(1);

		Assert.assertEquals("Admin", admin.getNom());

	}

	@Ignore
	@Test(expected = NullPointerException.class)
	public void itShouldNotFindAdminById() {
		Administrator admin = proxy.findAdminById(3);

		Assert.assertEquals("Admin", admin.getNom());

	}

	@Ignore
	@Test(expected = junit.framework.ComparisonFailure.class)
	public void itShouldFindAdminByIdAndCompareIt() {

		Administrator admin = proxy.findAdminById(1);
		Assert.assertEquals(admin.getNom(), "Admiiiiiin");
	}

	@Ignore
	@Test
	public void itShouldRemoveAdmin() {
		Assert.assertTrue(proxy.removeAdmin(proxy.findAdminById(1)));
	}

	@Ignore
	@Test(expected = AssertionFailedError.class)
	public void itShouldNotRemoveAdmin() {
		Assert.assertTrue(proxy.removeAdmin(proxy.findAdminById(45)));
	}

	@Ignore
	@Test
	public void itShouldUpdateAdmin() {
		Administrator admin = proxy.findAdminById(2);
		admin.setNom("cha5s");
		Assert.assertTrue(proxy.updateAdmin(admin));
	}

	@Ignore
	@Test(expected = NullPointerException.class)
	public void itShouldNotUpdateAdmin() {
		Administrator admin = proxy.findAdminById(40);
		admin.setNom("cha5s");
		Assert.assertTrue(proxy.updateAdmin(admin));
	}

	@Ignore
	@Test
	public void itShouldDisplayAdmin() {

		List<Administrator> AdminList = new ArrayList<Administrator>();
		AdminList = proxy.findAllAdmins();

		Assert.assertEquals(3, AdminList.size());

	}
	@Test(expected = AssertionFailedError.class)
	public void itShouldNotDisplayAdmin() {

		List<Administrator> AdminList = new ArrayList<Administrator>();
		AdminList = proxy.findAllAdmins();

		Assert.assertEquals(1, AdminList.size());

	}

}

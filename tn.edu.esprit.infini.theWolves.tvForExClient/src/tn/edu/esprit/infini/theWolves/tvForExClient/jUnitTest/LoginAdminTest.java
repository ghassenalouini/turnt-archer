package tn.edu.esprit.infini.theWolves.tvForExClient.jUnitTest;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Administrator;
import tn.edu.esprit.infini.theWolves.tvForEx.facade.interfaces.AdministratorFacadeRemote;
import tn.edu.esprit.infini.theWolves.tvForEx.facadeLocal.interfaces.AdminFacadeLocal;

public class LoginAdminTest {
	
	
	private AdministratorFacadeRemote proxy;

	@Before
	public void test(){
		
		try{
			
			Context context= new InitialContext();
		
			String jndiName = "TV-ForEx/tn.edu.esprit.infini.theWolves.tvForEx/AdministratorFacade!"
				+ AdministratorFacadeRemote.class.getCanonicalName();
	
			System.out.println("before lookup");
		
			proxy = (AdministratorFacadeRemote) context.lookup(jndiName); 
			
			System.out.println("after lookup");
		}catch (NamingException e)
		{
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	@Test

	public void testAjoutAdmin(){
		
		Administrator administrator= new Administrator();

		administrator.setNom("ayoub");
		administrator.setLogin("ayoub");
		administrator.setPassword("ayoub");
		administrator.setEmailAddress("ayoub@yahoo.fr");
		
		Assert.assertTrue(proxy.addAdmin(administrator));
	
	}
	
	@SuppressWarnings("deprecation")
	@Test
	@Ignore
	public void testLogin(){
		
		Administrator administrator= proxy.logInAdmin("ayoub", "ayoub");
		Assert.assertEquals("ayoub", administrator.getNom());
		
	}


}

		
		
	

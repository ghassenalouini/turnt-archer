package tn.edu.esprit.infini.theWolves.tvForExClient;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.ExchangeRate;
import tn.edu.esprit.infini.theWolves.tvForEx.facadeRemote.interfaces.ExchangeRateFacadeRemote;

public class test {

	
	public static void main(String[] args) {
		
		try {
			Context context = new InitialContext();

			System.out.println("aaa");
			
			String jndiName = "ejb:/tn.edu.esprit.infini.theWolves.tvForEx/ExchangeRateFacade!"
					+ ExchangeRateFacadeRemote.class.getCanonicalName();

			ExchangeRateFacadeRemote proxy = (ExchangeRateFacadeRemote) context.lookup(jndiName);
			
			
			ExchangeRate exchangeRate = new ExchangeRate();
			exchangeRate.setCurrencyTR("CAD");
			exchangeRate.setId(5);
			exchangeRate.setCurrency("USD");
			exchangeRate.setRate((float)1.5);
			
			
			proxy.findExchangeRateByCurrencyRT("EUR");
			

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
}

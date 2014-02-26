package tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;

@Remote
public interface CurrencyServicesRemote {

	List<Currency> findAllCurrencies();

	boolean addCurrency(Currency currency);
	

	Currency findCurrencyById(int id);


	
	
	
	

	
	
	
}

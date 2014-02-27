package tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;

@Local
public interface CurrencyServicesLocal {
	
	boolean addCurrency(Currency currency);

	boolean removeCurrency(Currency currency);

	boolean updateCurrency(Currency currency);

	Currency findCurrencyById(int id);

	List<Currency> findAllCurrencies();

}

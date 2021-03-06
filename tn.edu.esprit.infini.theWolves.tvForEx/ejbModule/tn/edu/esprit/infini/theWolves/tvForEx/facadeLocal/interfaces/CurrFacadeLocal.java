package tn.edu.esprit.infini.theWolves.tvForEx.facadeLocal.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;

@Local
public interface CurrFacadeLocal {
	
	boolean addCurrency(Currency currency);

	boolean removeCurrency(Currency currency);

	boolean updateCurrency(Currency currency);

	Currency findCurrencyByLabbel(String labbel);

	List<Currency> findAllCurrencies();

}

package tn.edu.esprit.infini.theWolves.tvForEx.facadeRemote.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;
/** **/
@Remote
public interface CurrencyFacadeRemote {

	boolean addCurrency(Currency currency);

	boolean removeCurrency(Currency currency);

	boolean updateCurrency(Currency currency);

	Currency findCurrencyByLabbel(String labbel);

	List<Currency> findAllCurrencies();

}

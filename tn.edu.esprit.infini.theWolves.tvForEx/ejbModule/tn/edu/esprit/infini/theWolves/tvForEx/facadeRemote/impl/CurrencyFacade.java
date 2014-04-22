package tn.edu.esprit.infini.theWolves.tvForEx.facadeRemote.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;
import tn.edu.esprit.infini.theWolves.tvForEx.facadeRemote.interfaces.CurrencyFacadeRemote;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.CurrencyServicesLocal;

/**
 * Session Bean implementation class CurrencyServices
 */
@Stateless
public class CurrencyFacade implements CurrencyFacadeRemote {

	@EJB
	CurrencyServicesLocal currencyServicesLocal;

	/**
	 * Default constructor.
	 */
	public CurrencyFacade() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Currency> findAllCurrencies() {		
		return currencyServicesLocal.findAllCurrencies();
	}

	@Override
	public boolean addCurrency(Currency currency) {
		return currencyServicesLocal.addCurrency(currency);
	}

	@Override
	public Currency findCurrencyById(int id) {
		return currencyServicesLocal.findCurrencyById(id);
	}

	@Override
	public boolean removeCurrency (Currency currency) {
		return currencyServicesLocal.removeCurrency(currency);
	}

	@Override
	public boolean updateCurrency(Currency currency) {
		return currencyServicesLocal.updateCurrency(currency);
	}
	

}

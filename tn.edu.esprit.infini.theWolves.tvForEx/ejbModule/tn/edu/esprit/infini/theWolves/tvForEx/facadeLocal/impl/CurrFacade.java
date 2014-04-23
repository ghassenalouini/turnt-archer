package tn.edu.esprit.infini.theWolves.tvForEx.facadeLocal.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;
import tn.edu.esprit.infini.theWolves.tvForEx.facadeLocal.interfaces.CurrFacadeLocal;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.CurrencyServicesLocal;

/**
 * Session Bean implementation class CurrFacade
 */
@Stateless
@LocalBean
public class CurrFacade implements CurrFacadeLocal {

	@EJB
	CurrencyServicesLocal currencyServicesLocal;

	/**
	 * Default constructor.
	 */
	public CurrFacade() {
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
	public Currency findCurrencyByLabbel(String labbel) {
		return currencyServicesLocal.findCurrencyByLabbel(labbel);
	}

	@Override
	public boolean removeCurrency(Currency currency) {
		return currencyServicesLocal.removeCurrency(currency);
	}

	@Override
	public boolean updateCurrency(Currency currency) {
		return currencyServicesLocal.updateCurrency(currency);
	}

}

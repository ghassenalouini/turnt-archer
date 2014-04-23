package tn.edu.esprit.infini.theWolves.tvForEx.facadeLocal.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.ExchangeRate;
import tn.edu.esprit.infini.theWolves.tvForEx.facadeLocal.interfaces.ExRateFacadeLocal;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.ExchangeRateServicesLocal;

/**
 * Session Bean implementation class ExRateFacade
 */
@Stateless
public class ExRateFacade implements ExRateFacadeLocal {

	@EJB
	ExchangeRateServicesLocal exchangeRateServicesLocal;

	/**
	 * Default constructor.
	 */
	public ExRateFacade() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ExchangeRate findExchangeRateById(int id) {
		return exchangeRateServicesLocal.findExchangeRateById(id);
	}

	@Override
	public boolean addExchangeRate(ExchangeRate exchangeRate) {
		return exchangeRateServicesLocal.addExchangeRate(exchangeRate);
	}

	@Override
	public boolean updateExchangeRate(ExchangeRate exchangeRate) {
		return exchangeRateServicesLocal.updateExchangeRate(exchangeRate);
	}

	@Override
	public boolean removeExchangeRate(ExchangeRate exchangeRate) {
		return exchangeRateServicesLocal.removeExchangeRate(exchangeRate);
	}

	@Override
	public List<ExchangeRate> findAllExchangeRate() {
		return exchangeRateServicesLocal.findAllExchangeRate();
	}

}

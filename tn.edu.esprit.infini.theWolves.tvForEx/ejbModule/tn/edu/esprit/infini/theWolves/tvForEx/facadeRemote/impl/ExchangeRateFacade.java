package tn.edu.esprit.infini.theWolves.tvForEx.facadeRemote.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.ExchangeRate;
import tn.edu.esprit.infini.theWolves.tvForEx.facadeRemote.interfaces.ExchangeRateFacadeRemote;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.ExchangeRateServicesLocal;

/**
 * Session Bean implementation class ExchangeRateFacade
 */
@Stateless
public class ExchangeRateFacade implements ExchangeRateFacadeRemote {

	@EJB
	ExchangeRateServicesLocal exchangeRateServicesLocal;

	/**
	 * Default constructor.
	 */
	public ExchangeRateFacade() {
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

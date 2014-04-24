package tn.edu.esprit.infini.theWolves.tvForEx.facadeLocal.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

	@PersistenceContext
	private EntityManager entityManager;

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

	@Override
	public ExchangeRate findExchangeRateByCurrencyRT(String currencyRT) {
		
		String jpql="select c from ExchangeRate c where c.currencyTR= :param";
		
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", currencyRT);
		Object object = null;
		try {
			object = query.getSingleResult();
			return (ExchangeRate) object;

		} catch (Exception e) {
			System.err.println("pas de currency TR ...");
		}
		return (ExchangeRate) object;

	}

}

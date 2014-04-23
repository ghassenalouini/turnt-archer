package tn.edu.esprit.infini.theWolves.tvForEx.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.ExchangeRate;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.ExchangeRateServicesLocal;

/**
 * Session Bean implementation class ExchangeRateServices
 */
@Stateless
public class ExchangeRateServices implements ExchangeRateServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public ExchangeRateServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ExchangeRate findExchangeRateById(int id) {
		return entityManager.find(ExchangeRate.class, id);
	}

	@Override
	public boolean addExchangeRate(ExchangeRate exchangeRate) {
		boolean b = false;
		try {
			entityManager.persist(exchangeRate);
			b = true;

		} catch (Exception e) {
			System.err.println("error add exchange rate ...");
		}
		return b;
	}

	@Override
	public boolean updateExchangeRate(ExchangeRate exchangeRate) {
		boolean b = false;
		try {
			entityManager.merge(exchangeRate);
			b = true;

		} catch (Exception e) {
			System.err.println("error update exchange rate ...");
		}
		return b;
	}

	@Override
	public boolean removeExchangeRate(ExchangeRate exchangeRate) {

		boolean b = false;
		try {
			entityManager.remove(entityManager.merge(exchangeRate));
			b = true;

		} catch (Exception e) {
			System.err.println("error remove exchange rate ...");
		}
		return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExchangeRate> findAllExchangeRate() {
		String jpql = "select e from ExchangeRate e";
		return entityManager.createQuery(jpql).getResultList();
	}

}

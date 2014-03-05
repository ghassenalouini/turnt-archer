package tn.edu.esprit.infini.theWolves.tvForEx.services.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.CurrencyServicesLocal;

/**
 * Session Bean implementation class CurrencyServices
 */
@Stateless
@LocalBean
public class CurrencyServices implements CurrencyServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public CurrencyServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addCurrency(Currency currency) {
		boolean b = false;
		try {
			entityManager.persist(currency);
			b = true;

		} catch (Exception e) {
			System.err.println("error add currency ...");
		}
		return b;
	}

	@Override
	public boolean removeCurrency(Currency currency) {

		boolean b = false;
		try {
			entityManager.remove(entityManager.merge(currency));
			b = true;
		} catch (Exception e) {
			System.err.println("error remove currency ...");
		}
		return b;
	}

	@Override
	public boolean updateCurrency(Currency currency) {
		boolean b = false;
		try {
			entityManager.merge(currency);
			b = true;

		} catch (Exception e) {
			System.err.println("error update currency ...");
		}
		return b;
	}

	@Override
	public Currency findCurrencyById(int id) {
		return entityManager.find(Currency.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Currency> findAllCurrencies() {
		String jpql = "select c from Currency c";
		return entityManager.createQuery(jpql).getResultList();
	}

}

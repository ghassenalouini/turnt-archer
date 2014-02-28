package tn.edu.esprit.infini.theWolves.tvForEx.services.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Trader;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.TraderServicesLocal;

/**
 * Session Bean implementation class TraderServices
 */
@Stateless
@LocalBean
public class TraderServices implements TraderServicesLocal {

	/**
	 * Default constructor.
	 */
	public TraderServices() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Trader findTraderbyId(int id) {
		return entityManager.find(Trader.class, id);
	}

	@Override
	public boolean addTrader(Trader trader) {
		boolean b = false;
		try {
			entityManager.persist(trader);
			b = true;

		} catch (Exception e) {
			System.err.println("error add trader ...");
		}
		return b;
	}

	@Override
	public boolean updateTrader(Trader trader) {
		boolean b = false;
		try {
			entityManager.merge(trader);
			b = true;

		} catch (Exception e) {
			System.err.println("error update customer ...");
		}
		return b;
	}

	@Override
	public boolean removeTrader(Trader trader) {
		boolean b = false;
		try {
			entityManager.remove(trader);
			b = true;

		} catch (Exception e) {
			System.err.println("error remove trader ...");
		}
		return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Trader> findAllTraders() {
		String jpql = "select t from Trader t";
		return entityManager.createQuery(jpql).getResultList();
	}

}

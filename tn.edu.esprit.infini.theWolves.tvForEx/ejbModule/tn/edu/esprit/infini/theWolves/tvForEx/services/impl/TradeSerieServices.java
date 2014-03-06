package tn.edu.esprit.infini.theWolves.tvForEx.services.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.TradeSerie;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.TradeSerieServicesLocal;

/**
 * Session Bean implementation class MarketServices
 */
@Stateless
@LocalBean
public class TradeSerieServices implements TradeSerieServicesLocal {

	/**
	 * Default constructor.
	 */
	public TradeSerieServices() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public TradeSerie findTradeSerieById(int id) {

		return entityManager.find(TradeSerie.class, id);
	}

	@Override
	public boolean addTradeSerie(TradeSerie tradeSerie) {
		boolean b = false;
		try {
			entityManager.persist(tradeSerie);
			b = true;

		} catch (Exception e) {
			System.err.println("error add trade serie ...");
		}
		return b;
	}

	@Override
	public boolean updateTradeSerie(TradeSerie tradeSerie) {
		boolean b = false;
		try {
			entityManager.merge(tradeSerie);
			b = true;

		} catch (Exception e) {
			System.err.println("error update trade serie ...");
		}
		return b;
	}

	@Override
	public boolean removeTradeSerie(TradeSerie tradeSerie) {
		boolean b = false;
		try {
			entityManager.remove(entityManager.merge(tradeSerie));

		} catch (Exception e) {
			System.err.println("error remove trade serie ...");
		}
		return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TradeSerie> findAllTradeSeries() {
		String jpql = "select t from TradeSerie t";
		return entityManager.createQuery(jpql).getResultList();
	}

}

package tn.edu.esprit.infini.theWolves.tvForEx.facade.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Trader;
import tn.edu.esprit.infini.theWolves.tvForEx.facade.interfaces.TraderFacadeRemote;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.TraderServicesLocal;

/**
 * Session Bean implementation class TraderServices
 */

@Stateless
@LocalBean
public class TraderFacade implements TraderFacadeRemote {

	@PersistenceContext
	private EntityManager entityManager;
	
	@EJB
	TraderServicesLocal traderServicesLocal;

	public TraderFacade() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Trader findTraderbyId(int id) {
		return traderServicesLocal.findTraderbyId(id);
	}

	@Override
	public boolean addTrader(Trader trader) {
		return traderServicesLocal.addTrader(trader);
	}

	@Override
	public boolean updateTrader(Trader trader) {
		return traderServicesLocal.updateTrader(trader);
	}

	@Override
	public boolean removeTrader(Trader trader) {
		return traderServicesLocal.removeTrader(trader);
	}

	@Override
	public List<Trader> findAllTraders() {
		return traderServicesLocal.findAllTraders();
	}

	@Override
	public Trader LogInTrader(String login, String password) {
		
		String jpql = "select t from Trader t where t.login=:param1 and t.pswd=:param2";
		Trader b = null;

		Query query = (Query) entityManager.createQuery(jpql);
		query.setParameter("param1", login);
		query.setParameter("param2", password);

		try {
			b = (Trader) query.getSingleResult();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return b;
	}

}

package tn.edu.esprit.infini.theWolves.tvForEx.facade.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Trader;
import tn.edu.esprit.infini.theWolves.tvForEx.facade.interfaces.TraderFacadeRemote;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.TraderServicesLocal;

/**
 * Session Bean implementation class TraderServices
 */
@Stateless
@LocalBean
public class TraderFacade implements TraderFacadeRemote {

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

}

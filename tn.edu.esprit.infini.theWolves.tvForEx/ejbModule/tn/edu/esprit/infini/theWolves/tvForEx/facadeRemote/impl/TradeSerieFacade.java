package tn.edu.esprit.infini.theWolves.tvForEx.facadeRemote.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.TradeSerie;
import tn.edu.esprit.infini.theWolves.tvForEx.facadeRemote.interfaces.TradeSerieFacadeRemote;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.TradeSerieServicesLocal;

/**
 * Session Bean implementation class MarketFacade
 */
@Stateless
@LocalBean
public class TradeSerieFacade implements TradeSerieFacadeRemote {

	/**
	 * Default constructor.
	 */

	@EJB
	TradeSerieServicesLocal marketServicesLocal;

	public TradeSerieFacade() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public TradeSerie findTradeSerieById(int id) {
		return marketServicesLocal.findTradeSerieById(id);
	}

	@Override
	public boolean addTradeSerie(TradeSerie tradeSerie) {
		return marketServicesLocal.addTradeSerie(tradeSerie);
	}

	@Override
	public boolean updateTradeSerie(TradeSerie tradeSerie) {
		return marketServicesLocal.updateTradeSerie(tradeSerie);
	}

	@Override
	public boolean removeTradeSerie(TradeSerie tradeSerie) {
		return marketServicesLocal.removeTradeSerie(tradeSerie);
	}

	@Override
	public List<TradeSerie> findAllTradeSeries() {
		return marketServicesLocal.findAllTradeSeries();
	}

}

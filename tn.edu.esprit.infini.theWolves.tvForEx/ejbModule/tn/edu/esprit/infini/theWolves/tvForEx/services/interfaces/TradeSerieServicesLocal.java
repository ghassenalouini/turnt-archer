package tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.TradeSerie;

@Local
public interface TradeSerieServicesLocal {

	public TradeSerie findTradeSerieById(int id);

	public boolean addTradeSerie(TradeSerie tradeSerie);

	public boolean updateTradeSerie(TradeSerie tradeSerie);

	public boolean removeTradeSerie(TradeSerie tradeSerie);

	public List<TradeSerie> findAllTradeSeries();

}

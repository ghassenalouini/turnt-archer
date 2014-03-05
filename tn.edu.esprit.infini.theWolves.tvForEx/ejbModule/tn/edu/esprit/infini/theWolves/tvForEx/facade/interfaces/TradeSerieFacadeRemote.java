package tn.edu.esprit.infini.theWolves.tvForEx.facade.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.TradeSerie;

@Remote
public interface TradeSerieFacadeRemote {
	
	public TradeSerie findTradeSerieById(int id);

	public boolean addTradeSerie(TradeSerie tradeSerie);

	public boolean updateTradeSerie(TradeSerie tradeSerie);

	public boolean removeTradeSerie(TradeSerie tradeSerie);

	public List<TradeSerie> findAllTradeSeries();

}

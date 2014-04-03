package tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.TradeSerie;

@Local
public interface TradeSerieServicesLocal {
	/**
	 * La m�thode finTraderSerieById permet de retourner un tradeSerie en lui
	 * donnant en param�tre un id
	 **/
	public TradeSerie findTradeSerieById(int id);

	/**
	 * La m�thode addSerie permet d'ajouter un tradserie avec persist l'attacher
	 * et le rendre persistent
	 **/
	public boolean addTradeSerie(TradeSerie tradeSerie);

	/**
	 * La m�thode updateTradeSerie permet de faire un merge sur un objet pour
	 * d'eventuel modifs
	 **/
	public boolean updateTradeSerie(TradeSerie tradeSerie);

	/**
	 * la m�thode removeTradeSerie permet de supprimer un tradeSerie et le
	 * d�tacher, cette m�thode prend en param�tre un tradeserie et retourne une
	 * valeur boolean true s'il a �t�t supprim� false sinon
	 **/
	public boolean removeTradeSerie(TradeSerie tradeSerie);

	/**
	 * Cette m�thode findAllTradeSeries permet de retourner une liste de
	 * tradeSeries avec une requ�te cr��e en JPQL
	 **/
	public List<TradeSerie> findAllTradeSeries();

}

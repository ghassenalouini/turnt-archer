package tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.TradeSerie;

@Local
public interface TradeSerieServicesLocal {
	/**
	 * La méthode finTraderSerieById permet de retourner un tradeSerie en lui
	 * donnant en paramétre un id
	 **/
	public TradeSerie findTradeSerieById(int id);

	/**
	 * La méthode addSerie permet d'ajouter un tradserie avec persist l'attacher
	 * et le rendre persistent
	 **/
	public boolean addTradeSerie(TradeSerie tradeSerie);

	/**
	 * La méthode updateTradeSerie permet de faire un merge sur un objet pour
	 * d'eventuel modifs
	 **/
	public boolean updateTradeSerie(TradeSerie tradeSerie);

	/**
	 * la méthode removeTradeSerie permet de supprimer un tradeSerie et le
	 * détacher, cette méthode prend en paramétre un tradeserie et retourne une
	 * valeur boolean true s'il a étét supprimé false sinon
	 **/
	public boolean removeTradeSerie(TradeSerie tradeSerie);

	/**
	 * Cette méthode findAllTradeSeries permet de retourner une liste de
	 * tradeSeries avec une requéte créée en JPQL
	 **/
	public List<TradeSerie> findAllTradeSeries();

}

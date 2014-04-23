package tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;

@Local
public interface CurrencyServicesLocal {
	/**
	 * La m�thode add permet d'ajouter un nouveau currency � la table currency
	 * elle prend en param�tre un currency et retourne une valeur boolean true
	 * si currency a �t� ajout� false sinon
	 **/
	boolean addCurrency(Currency currency);

	/**
	 * La m�thode remove permet de supprimer un currency de la table currency
	 * elle prend en param�tre un currency et retourne un boolean true si le
	 * currency a �t� supprim� false sinon
	 **/
	boolean removeCurrency(Currency currency);

	/** la m�thode update permet d'attacher un currency avec la m�thode merge **/
	boolean updateCurrency(Currency currency);

	/**
	 * la m�thode find byid permet de retourner un currency si on lui envoie en
	 * param�tre son id!
	 **/
	Currency findCurrencyByLabbel(String labbel);

	/**
	 * la m�thode findAllCurrencies retourne tous les currency en forme de
	 * list!!! pour utiliser cette m�thode on cr�e une requ�te en JPQL qui est
	 * comptaible a tous les sgbd
	 **/
	List<Currency> findAllCurrencies();

}

package tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;

@Local
public interface CurrencyServicesLocal {
	/**
	 * La méthode add permet d'ajouter un nouveau currency à la table currency
	 * elle prend en paramétre un currency et retourne une valeur boolean true
	 * si currency a été ajouté false sinon
	 **/
	boolean addCurrency(Currency currency);

	/**
	 * La méthode remove permet de supprimer un currency de la table currency
	 * elle prend en paramétre un currency et retourne un boolean true si le
	 * currency a été supprimé false sinon
	 **/
	boolean removeCurrency(Currency currency);

	/** la méthode update permet d'attacher un currency avec la méthode merge **/
	boolean updateCurrency(Currency currency);

	/**
	 * la méthode find byid permet de retourner un currency si on lui envoie en
	 * paramétre son id!
	 **/
	Currency findCurrencyByLabbel(String labbel);

	/**
	 * la méthode findAllCurrencies retourne tous les currency en forme de
	 * list!!! pour utiliser cette méthode on crée une requéte en JPQL qui est
	 * comptaible a tous les sgbd
	 **/
	List<Currency> findAllCurrencies();

}

package tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Transaction;

@Local
public interface TransactionServicesLocal {
	/**
	 * addTransaction permet d'attacher un objet avec persist et l'ajouter dans
	 * la base de données
	 **/
	public boolean addTransactionC(Transaction transaction);

	/**
	 * UpdateTransaction permet de faire un merge sur une transaction en prenant
	 * en compte une transaction et retourner une valeur boolean s'il a été
	 * modifié true, false sinon
	 **/
	public boolean updateTransaction(Transaction transaction);

	/**
	 * Un removeTransaction permet de supprimer une transaction en prenant en
	 * compte une transaction et retourner une valeur boolean true s'il a été
	 * supprimé, false sinon
	 **/
	public boolean removeTransaction(Transaction transaction);

	/**
	 * FindTransaction permeet de faire une recherche sur une transaction en
	 * pranant en paramétre un id et retourner une transaction
	 **/

	public Transaction findTransactionById(int id);

	/**
	 * la méthode findAllTransactions permet de retourner une list de
	 * transaction
	 **/
	public List<Transaction> findAllTransactions();

}

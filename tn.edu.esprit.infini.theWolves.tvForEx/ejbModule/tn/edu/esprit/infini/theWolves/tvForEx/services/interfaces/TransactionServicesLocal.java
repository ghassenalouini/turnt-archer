package tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Transaction;

@Local
public interface TransactionServicesLocal {
	/**
	 * addTransaction permet d'attacher un objet avec persist et l'ajouter dans
	 * la base de donn�es
	 **/
	public boolean addTransactionC(Transaction transaction);

	/**
	 * UpdateTransaction permet de faire un merge sur une transaction en prenant
	 * en compte une transaction et retourner une valeur boolean s'il a �t�
	 * modifi� true, false sinon
	 **/
	public boolean updateTransaction(Transaction transaction);

	/**
	 * Un removeTransaction permet de supprimer une transaction en prenant en
	 * compte une transaction et retourner une valeur boolean true s'il a �t�
	 * supprim�, false sinon
	 **/
	public boolean removeTransaction(Transaction transaction);

	/**
	 * FindTransaction permeet de faire une recherche sur une transaction en
	 * pranant en param�tre un id et retourner une transaction
	 **/

	public Transaction findTransactionById(int id);

	/**
	 * la m�thode findAllTransactions permet de retourner une list de
	 * transaction
	 **/
	public List<Transaction> findAllTransactions();

}

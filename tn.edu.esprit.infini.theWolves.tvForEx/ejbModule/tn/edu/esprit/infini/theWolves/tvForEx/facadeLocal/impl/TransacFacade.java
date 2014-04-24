package tn.edu.esprit.infini.theWolves.tvForEx.facadeLocal.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Transaction;
import tn.edu.esprit.infini.theWolves.tvForEx.facadeLocal.interfaces.TransacFacadeLocal;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.TransactionServicesLocal;

/**
 * Session Bean implementation class TransacFacade
 */
@Stateless
public class TransacFacade implements TransacFacadeLocal {

	@EJB
	private TransactionServicesLocal transactionServicesLocal;

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * 
	 * Default constructor.
	 */
	public TransacFacade() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addTransactionC(Transaction transaction) {

		return transactionServicesLocal.addTransactionC(transaction);
	}

	@Override
	public boolean updateTransaction(Transaction transaction) {
		return transactionServicesLocal.updateTransaction(transaction);
	}

	@Override
	public boolean removeTransaction(Transaction transaction) {
		return transactionServicesLocal.removeTransaction(transaction);
	}

	@Override
	public Transaction findTransactionById(int id) {
		return transactionServicesLocal.findTransactionById(id);
	}

	@Override
	public List<Transaction> findAllTransactions() {
		return transactionServicesLocal.findAllTransactions();
	}

}

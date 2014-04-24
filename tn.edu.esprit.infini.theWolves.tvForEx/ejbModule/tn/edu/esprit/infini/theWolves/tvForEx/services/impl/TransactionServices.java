package tn.edu.esprit.infini.theWolves.tvForEx.services.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Transaction;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.TransactionServicesLocal;

/**
 * Session Bean implementation class TransactionServices
 */
@Stateless
@LocalBean
public class TransactionServices implements TransactionServicesLocal {

	/**
	 * Default constructor.
	 */
	public TransactionServices() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public boolean addTransactionC(Transaction transaction) {
		boolean b = false;
		try {
			entityManager.persist(transaction);
			b = true;

		} catch (Exception e) {
			System.err.println("error add transaction ...");
		}
		return b;
	}

	@Override
	public boolean updateTransaction(Transaction transaction) {
		boolean b = false;
		try {
			entityManager.merge(transaction);
			b = true;

		} catch (Exception e) {
			System.err.println("error update transaction ...");
		}
		return b;
	}

	@Override
	public boolean removeTransaction(Transaction transaction) {
		boolean b = false;
		try {
			entityManager.remove(transaction);
			b = true;

		} catch (Exception e) {
			System.err.println("error remove transaction ...");
		}
		return b;
	}

	@Override
	public Transaction findTransactionById(int id) {

		return entityManager.find(Transaction.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Transaction> findAllTransactions() {
		String jpql = "select t from Transaction t";
		return entityManager.createQuery(jpql).getResultList();

	}

}

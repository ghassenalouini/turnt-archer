package tn.edu.esprit.infini.theWolves.tvForEx.facade.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Bank;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Customer;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Transaction;
import tn.edu.esprit.infini.theWolves.tvForEx.facade.interfaces.PositionFacadeRemote;
import tn.edu.esprit.infini.theWolves.tvForEx.facade.interfaces.TransactionFacadeRemote;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.TransactionServicesLocal;

@Stateless
public class TransactionFacade implements TransactionFacadeRemote {

	@PersistenceContext
	private EntityManager entityManager;
	
	@EJB
	TransactionServicesLocal transactionServicesLocal;
	
	@EJB
	PositionFacadeRemote positionFacadeRemote;
	
	@Override
	public boolean addTransaction(Customer customer, Currency currency,
			String typeOfTransaction, int amount, float cotation) {
		boolean b = false;
		try {
			Transaction transaction = new Transaction(typeOfTransaction,
					amount, customer, currency, cotation);
			entityManager.persist(transaction);
			b = true;

		} catch (Exception e) {
			System.err.println("error add transaction ...");
		}
		return b;
	}

	@Override
	public boolean addCrossTransaction(Customer customer, Customer customerBid,
			Currency currency, Currency currencyCross, String type, int amount,
			float cotation, float cotationBase) {

		Transaction transactionCross = new Transaction(type, amount, cotation,
				cotationBase, customer, currency, customerBid, currencyCross);

		boolean b = false;
		try {

			positionFacadeRemote.updatePosition(transactionCross);
			entityManager.persist(transactionCross);
			b = true;

		} catch (Exception e) {
			System.err.println("error addCross Transaction ...");
		}
		return b;
	}

	@Override
	public boolean createOffer(Bank bank, Currency currency, float cotation) {
		boolean b = false;
		try {
			Transaction transaction = new Transaction(cotation, bank, currency);
			entityManager.persist(transaction);
			b = true;

		} catch (Exception e) {
			System.err.println("error create offer ...");
		}
		return b;
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

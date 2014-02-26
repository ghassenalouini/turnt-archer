package tn.edu.esprit.infini.theWolves.tvForEx.services.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Bank;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Customer;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Transaction;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.TransactionServicesRemote;

@Stateless
public class TransactionServices implements TransactionServicesRemote {

	@PersistenceContext
	private EntityManager entityManager;

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
			System.err.println("emmm haw fibali ...");
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
            
			PositionServices positionServices= new PositionServices();
			positionServices.updatePosition(transactionCross);
			entityManager.persist(transactionCross);
			b = true;

		} catch (Exception e) {
			System.err.println("emmm haw fibali ...");
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
			System.err.println("emmm haw fibali ...");
		}
		return b;
	}

}

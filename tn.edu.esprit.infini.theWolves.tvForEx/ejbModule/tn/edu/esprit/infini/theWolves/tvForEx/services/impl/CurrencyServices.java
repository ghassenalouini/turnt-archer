package tn.edu.esprit.infini.theWolves.tvForEx.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Bank;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Customer;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Position;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Transaction;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.CurrencyServicesRemote;

/**
 * Session Bean implementation class CurrencyServices
 */
@Stateless
public class CurrencyServices implements CurrencyServicesRemote {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public CurrencyServices() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Currency> findAllCurrencies() {
		String jpql = "select c from Currency c";
		return entityManager.createQuery(jpql).getResultList();
		
	}

	@Override
	public boolean addCurrency(Currency currency) {
		boolean b = false;
		try {
			entityManager.persist(currency);
			b = true;

		} catch (Exception e) {
			System.err.println("emmm haw fibali ...");
		}
		return b;
	}

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
	public Customer findCustomerById(int id) {

		return entityManager.find(Customer.class, id);
	}

	@Override
	public Currency findCurrencyById(int id) {

		return entityManager.find(Currency.class, id);
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

	@Override
	public boolean addBank(Bank bank) {
		boolean b = false;
		try {
			entityManager.persist(bank);
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
			entityManager.persist(transactionCross);
			updatePosition(transactionCross);
			b = true;

		} catch (Exception e) {
			System.err.println("emmm haw fibali ...");
		}
		return b;

	}

	@Override
	public boolean addCustomer(Customer customer) {
		boolean b = false;
		try {
			entityManager.persist(customer);
			b = true;

		} catch (Exception e) {
			System.err.println("emmm haw fibali ...");
		}
		return b;

	}

	@Override
	public void updatePosition(Transaction transaction) {

		try {

			// // the buyer bank
			Position position = findPositionByBankCurrency(
					transaction.getCustomer(), transaction.getCurrency());
			if (position == null) {
				System.out.println("pas de position pr la bank 1");
				position = new Position(transaction.getCustomer(),
						transaction.getCurrency(), transaction.getAmount(),
						transaction.getCotation());

			} else if (position != null) {
				System.out.println("la position pr la bank 1 est modifier");
				position.setCredit(position.getCredit()
						+ transaction.getAmount());
				position.setAverageCost(((position.getAverageCost() * position
						.getCredit()) + (transaction.getCotation() * transaction
						.getAmount()))
						/ (position.getCredit() + transaction.getAmount()));
				System.out.println("lemm" + position.getAverageCost());
			}

			Position position2 = findPositionByBankCurrency(
					transaction.getCustomer(), transaction.getCurrencyCross());

			if (position2 == null) {
				position2 = new Position(transaction.getCustomer(),
						transaction.getCurrencyCross(),
						-(transaction.getCotation() * transaction.getAmount()));

			} else if (position2 != null) {
				position2
						.setCredit(position2.getCredit()
								- (transaction.getCotation() * transaction
										.getAmount()));

			}

			// // the seller bank
			Position position3 = findPositionByBankCurrency(
					transaction.getCustomerCross(), transaction.getCurrency());
			if (position3 == null) {
				position3 = new Position(transaction.getCustomerCross(),
						transaction.getCurrency(), -transaction.getAmount());

			} else if (position3 != null) {
				position3.setCredit(position3.getCredit()
						- transaction.getAmount());

			}

			Position position4 = findPositionByBankCurrency(
					transaction.getCustomerCross(),
					transaction.getCurrencyCross());
			if (position4 == null) {
				position4 = new Position(transaction.getCustomerCross(),
						transaction.getCurrencyCross(),
						(transaction.getCotation() * transaction.getAmount()),
						transaction.getCotationBase());
			} else if (position4 != null) {
				position4.setCredit(position4.getCredit()
						+ transaction.getCotation() * transaction.getAmount());
				position4
						.setAverageCost(((position.getAverageCost() * position
								.getCredit()) + (transaction.getCotation()
								* transaction.getAmount() * transaction
									.getCotationBase()))
								/ (position.getCredit() + (transaction
										.getAmount() * transaction
										.getCotation())));
			}

			List<Position> positions = new ArrayList<Position>();
			positions.add(position);
			positions.add(position2);
			positions.add(position3);
			positions.add(position4);
			for (Position p : positions) {
				entityManager.merge(p);
			}

		} catch (Exception e) {
			System.err.println("emmm haw fibali ...");
		}

	}

	@Override
	public Position findPositionByBankCurrency(Customer customer,
			Currency currency) {
		String jpql = "select p from Position p where p.customer= :param1 and p.currency= :param2";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", customer);
		query.setParameter("param2", currency);

		Object object = null;
		try {
			object = query.getSingleResult();
			return (Position) object;

		} catch (Exception e) {
			System.err.println("pas de position ...");
		}
		return (Position) object;

	}

}

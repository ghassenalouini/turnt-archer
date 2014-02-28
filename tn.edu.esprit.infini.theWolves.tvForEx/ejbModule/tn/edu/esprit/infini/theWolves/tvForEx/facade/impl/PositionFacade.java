package tn.edu.esprit.infini.theWolves.tvForEx.facade.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Customer;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Position;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Transaction;
import tn.edu.esprit.infini.theWolves.tvForEx.facade.interfaces.PositionFacadeRemote;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.PositionServicesLocal;

@Stateless
public class PositionFacade implements PositionFacadeRemote {

	@PersistenceContext
	private EntityManager entityManager;

	@EJB
	PositionServicesLocal positionServicesLocal;

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
				System.out.println("la position pr la bank 1 est modifi??");
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
			System.err.println("update position error ...");
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

	@Override
	public boolean addPosition(Position position) {
		return positionServicesLocal.addPosition(position);
	}

	@Override
	public boolean removePosition(Position position) {
		return positionServicesLocal.removePosition(position);
	}

	@Override
	public List<Position> findAllPositions() {
		return positionServicesLocal.findAllPositions();
	}

	@Override
	public boolean upTodatePosition(Position position) {
		return positionServicesLocal.upTodatePosition(position);
	}

	@Override
	public Position findPositionById(int id) {
		return positionServicesLocal.findPositionById(id);
	}

}

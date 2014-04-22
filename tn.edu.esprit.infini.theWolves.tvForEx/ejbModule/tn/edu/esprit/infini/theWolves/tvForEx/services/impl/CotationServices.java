package tn.edu.esprit.infini.theWolves.tvForEx.services.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Administrator;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Bank;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Cotation;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Customer;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.CotationServicesLocal;

/**
 * Session Bean implementation class CotationServices
 */
@Stateless
@LocalBean
public class CotationServices implements CotationServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public CotationServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Cotation findcotationByBankCurrency(Customer customer,
			Currency currency) {
		String jpql = "select p from Cotation p where p.customer= :param1 and p.currency= :param2";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", customer);
		query.setParameter("param2", currency);
		Object object = null;
		try {
			object = query.getSingleResult();
			return (Cotation) object;

		} catch (Exception e) {
			System.err.println("pas de position ...");
		}
		return (Cotation) object;

	}

	public boolean addCotation(Cotation cotation) {
		boolean b = false;
		try {
			entityManager.persist(cotation);
			b = true;

		} catch (Exception e) {
			System.err.println("error add cotation ...");
		}
		return b;
	}
	
	
	public boolean removeCotation(Cotation cotatio) {
		boolean b = false;
		try {
			entityManager.remove(entityManager.merge(cotatio));
			b = true;
		} catch (Exception e) {
			System.err.println("error remove currency ...");
		}
		return b;
	}


	public List<Cotation> findcotationByBank(Bank bank) {
		String jpql = "select p from Cotation p where p.customer= :param1";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", bank);
		
		
		return entityManager.createQuery(jpql).getResultList();

	}


	public boolean updateCotation(Cotation cotation) {
		boolean b = false;
		try {
			entityManager.merge(cotation);
			b = true;

		} catch (Exception e) {
			System.err.println("error update cotation ...");
		}
		return b;
	}
	
	

	public List<Administrator> findAllCotation() {
		String jpql = "select p from Cotation p";
		
		
		
		
		return entityManager.createQuery(jpql).getResultList();

	}

	public Cotation findCotationByCurrecy(Currency currency) {
		String jpql = "select p from Cotation p where p.currency= :param2";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param2", currency);
		Object object = null;
		try {
			object = query.getSingleResult();
			return (Cotation) object;

		} catch (Exception e) {
			System.err.println("pas de Cotation ...");
		}
		return (Cotation) object;

	}
}

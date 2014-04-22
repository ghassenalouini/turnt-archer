package tn.edu.esprit.infini.theWolves.tvForEx.facadeLocal.impl;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Customer;
import tn.edu.esprit.infini.theWolves.tvForEx.facadeLocal.interfaces.CustFacadeLocal;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.CustomerServicesLocal;

/**
 * Session Bean implementation class CustFacade
 */
@Stateless
@LocalBean
public class CustFacade implements CustFacadeLocal {

	@EJB
	private CustomerServicesLocal customerServicesLocal;
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public CustFacade() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Customer loginCustomer(String login, String password) {

		Customer found = null;
		String jpql = "select c from Customer c where c.login=:login and c.password=:password";

		Query query = entityManager.createQuery(jpql);

		query.setParameter("login", login);
		query.setParameter("password", password);

		try {

			found = (Customer) query.getSingleResult();

		} catch (Exception ex) {
		}

		return found;
	}

	@Override
	public boolean addCustomer(Customer customer) {
		return customerServicesLocal.addCustomer(customer);
	}

}

package tn.edu.esprit.infini.theWolves.tvForEx.services.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Customer;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.CustomerServicesLocal;

/**
 * Session Bean implementation class CustomerServices
 */
@Stateless
@LocalBean
public class CustomerServices implements CustomerServicesLocal {

	/**
	 * Default constructor.
	 */
	public CustomerServices() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Customer findCustomerById(int id) {
		return entityManager.find(Customer.class, id);
	}

	@Override
	public boolean addCustomer(Customer customer) {
		boolean b = false;
		try {
			entityManager.persist(customer);
			b = true;

		} catch (Exception e) {
			System.err.println("error add customer ...");
		}
		return b;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		boolean b = false;
		try {
			entityManager.merge(customer);
			b = true;

		} catch (Exception e) {
			System.err.println("error update customer ...");
		}
		return b;
	}

	@Override
	public boolean removeCustomer(Customer customer) {
		boolean b = false;
		try {
			entityManager.remove(customer);
			b = true;

		} catch (Exception e) {
			System.err.println("error remove customer ...");
		}
		return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> findAllCustomers() {
		String jpql = "select c from Customer c";
		return entityManager.createQuery(jpql).getResultList();
	}

}

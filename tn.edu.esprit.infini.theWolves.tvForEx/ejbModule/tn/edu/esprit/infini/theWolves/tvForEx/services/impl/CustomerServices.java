package tn.edu.esprit.infini.theWolves.tvForEx.services.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Customer;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.CustomerServicesRemote;

@Stateless
public class CustomerServices implements CustomerServicesRemote {

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
			System.err.println("emmm haw fibali ...");
		}
		return b;
	}

}

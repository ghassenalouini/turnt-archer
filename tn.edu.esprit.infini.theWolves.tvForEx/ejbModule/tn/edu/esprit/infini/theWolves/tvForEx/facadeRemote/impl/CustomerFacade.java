package tn.edu.esprit.infini.theWolves.tvForEx.facadeRemote.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import tn.edu.esprit.infini.theWolves.tvForEx.domain.Customer;
import tn.edu.esprit.infini.theWolves.tvForEx.facadeRemote.interfaces.CustomerFacadeRemote;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.CustomerServicesLocal;

@Stateless
public class CustomerFacade implements CustomerFacadeRemote {

	@EJB
	CustomerServicesLocal customerServicesLocal;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Customer findCustomerById(int id) {
		return customerServicesLocal.findCustomerById(id);
	}

	@Override
	public boolean addCustomer(Customer customer) {
		return customerServicesLocal.addCustomer(customer);
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		return customerServicesLocal.updateCustomer(customer);
	}

	@Override
	public boolean removeCustomer(Customer customer) {
		return customerServicesLocal.removeCustomer(customer);

	}

	@Override
	public List<Customer> findAllCustomers() {
		return customerServicesLocal.findAllCustomers();

	}

	@Override
	public Customer LogInCustomer(String login, String password) {

		String jpql = "select c from Customer c where c.login=:param1 and c.pswd=:param2";
		Customer b = null;

		Query query = (Query) entityManager.createQuery(jpql);
		query.setParameter("param1", login);
		query.setParameter("param2", password);

		try {
			b = (Customer) query.getSingleResult();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return b;

	}

}

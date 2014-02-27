package tn.edu.esprit.infini.theWolves.tvForEx.facade.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Customer;
import tn.edu.esprit.infini.theWolves.tvForEx.facade.interfaces.CustomerFacadeRemote;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.CustomerServicesLocal;

@Stateless
public class CustomerFacade implements CustomerFacadeRemote {

	@EJB
	CustomerServicesLocal customerServicesLocal;

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

}

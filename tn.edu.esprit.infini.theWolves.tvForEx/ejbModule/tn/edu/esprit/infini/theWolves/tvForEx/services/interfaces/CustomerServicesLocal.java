package tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Customer;

@Local
public interface CustomerServicesLocal {

	public Customer findCustomerById(int id);

	public boolean addCustomer(Customer customer);

	public boolean updateCustomer(Customer customer);

	public boolean removeCustomer(Customer customer);

	public List<Customer> findAllCustomers();

}
package tn.edu.esprit.infini.theWolves.tvForEx.facade.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Customer;

@Local
public interface CustomerFacadeLocal {

	public Customer findCustomerById(int id);

	public boolean addCustomer(Customer customer);

	public boolean updateCustomer(Customer customer);

	public boolean removeCustomer(Customer customer);

	public List<Customer> findAllCustomers();
	
	public Customer LogInCustomer(String login, String password); 
	
}

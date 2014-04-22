package tn.edu.esprit.infini.theWolves.tvForEx.facadeRemote.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Customer;

@Remote
public interface CustomerFacadeRemote {

	public Customer findCustomerById(int id);

	public boolean addCustomer(Customer customer);

	public boolean updateCustomer(Customer customer);

	public boolean removeCustomer(Customer customer);

	public List<Customer> findAllCustomers();
	
	public Customer LogInCustomer(String login, String password); 

}

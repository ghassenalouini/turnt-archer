package tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces;

import javax.ejb.Remote;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Customer;

@Remote
public interface CustomerServicesRemote {
	
	
	 public Customer findCustomerById(int id);
	 boolean addCustomer(Customer customer);
}

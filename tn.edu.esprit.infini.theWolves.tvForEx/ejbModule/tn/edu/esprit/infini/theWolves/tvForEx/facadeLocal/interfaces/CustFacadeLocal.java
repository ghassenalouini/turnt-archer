package tn.edu.esprit.infini.theWolves.tvForEx.facadeLocal.interfaces;

import javax.ejb.Local;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Customer;

@Local
public interface CustFacadeLocal {

	public Customer loginCustomer(String login, String password);
	
	public boolean addCustomer(Customer customer);

}

package tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Customer;

@Local
public interface CustomerServicesLocal {
	/**
	 * La classe customer est la classe mére dont hérite les classes bank,
	 * central bank corporate et trader
	 **/

	/**
	 * la méthode findCustomerByID permet de retourner un customer en prenant en
	 * paramétre un id
	 **/
	public Customer findCustomerById(int id);

	/**
	 * la méthode add permet d'attacher l'entity object avec persist et retourne
	 * une valeur boolean true s'il a été managed et ajouté dans la base
	 **/
	public boolean addCustomer(Customer customer);

	/**
	 * La méthode update avec merge permet de rattacher un objet entity qui est
	 * customer qui a été détaché pour pouvoir le modifier
	 **/
	public boolean updateCustomer(Customer customer);

	/**
	 * la méthode remove permet de détacher l'objet entity et le supprimer de la
	 * base de données
	 **/
	public boolean removeCustomer(Customer customer);

	/** findAllCustomer permet de retourner une liste de customer **/
	public List<Customer> findAllCustomers();

}

package tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Customer;

@Local
public interface CustomerServicesLocal {
	/**
	 * La classe customer est la classe m�re dont h�rite les classes bank,
	 * central bank corporate et trader
	 **/

	/**
	 * la m�thode findCustomerByID permet de retourner un customer en prenant en
	 * param�tre un id
	 **/
	public Customer findCustomerById(int id);

	/**
	 * la m�thode add permet d'attacher l'entity object avec persist et retourne
	 * une valeur boolean true s'il a �t� managed et ajout� dans la base
	 **/
	public boolean addCustomer(Customer customer);

	/**
	 * La m�thode update avec merge permet de rattacher un objet entity qui est
	 * customer qui a �t� d�tach� pour pouvoir le modifier
	 **/
	public boolean updateCustomer(Customer customer);

	/**
	 * la m�thode remove permet de d�tacher l'objet entity et le supprimer de la
	 * base de donn�es
	 **/
	public boolean removeCustomer(Customer customer);

	/** findAllCustomer permet de retourner une liste de customer **/
	public List<Customer> findAllCustomers();

}

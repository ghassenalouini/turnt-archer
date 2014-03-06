package tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Administrator;

@Local
public interface AdministratorServicesLocal {

	/**
	 * c'est une methode qui permet d'ajouter un nouveau administrateur et pred
	 * en parametre un objet de la classe Administrateur
	 **/
	boolean addAdmin(Administrator administrator);

	/**
	 * C'est une m�thode qui permet de supprimer un administrateur et prend en
	 * param�tre un objet de type Administrateur et retourne true si il est
	 * supprim� false sinon
	 **/
	boolean removeAdmin(Administrator administrator);

	/**
	 * la m�thode update permet de mettre � jour la table avec la m�thode merge
	 * qui fait renvoie une instance g�r�e de l'entit� administrateur en prenant
	 * en compte un objet de type administrateur
	 **/
	boolean updateCurrency(Administrator administrator);

	/**
	 * La methode find fait des recherches d'un administrator prend en param�tre
	 * un id et retourne l'admistrateur correspond
	 **/
	Administrator findAdminById(int id);

	/**
	 * cette m�thode retourne une liste d'administrateur en creant une requ�te
	 * JPQL
	 **/
	List<Administrator> findAllAdmins();
	/** Method for login **/
}

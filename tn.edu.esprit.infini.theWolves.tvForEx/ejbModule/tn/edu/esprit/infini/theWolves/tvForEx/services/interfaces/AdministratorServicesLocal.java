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
	 * C'est une méthode qui permet de supprimer un administrateur et prend en
	 * paramétre un objet de type Administrateur et retourne true si il est
	 * supprimé false sinon
	 **/
	boolean removeAdmin(Administrator administrator);

	/**
	 * la méthode update permet de mettre à jour la table avec la méthode merge
	 * qui fait renvoie une instance gérée de l'entité administrateur en prenant
	 * en compte un objet de type administrateur
	 **/
	boolean updateCurrency(Administrator administrator);

	/**
	 * La methode find fait des recherches d'un administrator prend en paramétre
	 * un id et retourne l'admistrateur correspond
	 **/
	Administrator findAdminById(int id);

	/**
	 * cette méthode retourne une liste d'administrateur en creant une requéte
	 * JPQL
	 **/
	List<Administrator> findAllAdmins();
	/** Method for login **/
}

package tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Position;

@Local
public interface PositionServicesLocal {
	/**
	 * Avec persist on permet d'ajouter une position et l'attacher, elle prend
	 * en param�tre un objet de type position et retourne une valeur boolean
	 * true s'il a �t� ajout� false sinon
	 **/
	public boolean addPosition(Position position);

	/**
	 * avec merge on permet d'attacher un objet pour pouvoir faire des modids
	 * sur lui elle prend en param�tre un objet de type position et retourne une
	 * valeur boolean
	 **/
	public boolean upTodatePosition(Position position);

	/**
	 * avec la m�thode remove on supprime un objet et on le d�tache du context
	 * de persistence il n'est plus g�r� par le GE
	 **/
	public boolean removePosition(Position position);

	/** la m�thode findPositionById permet de rechercher une position par son id **/
	public Position findPositionById(int id);

	/**
	 * La m�thode findAllPosition permet de retourner une liste de position en
	 * creant une requ�te avec JPQL
	 **/
	public List<Position> findAllPositions();
}

package tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Position;

@Local
public interface PositionServicesLocal {
	/**
	 * Avec persist on permet d'ajouter une position et l'attacher, elle prend
	 * en paramétre un objet de type position et retourne une valeur boolean
	 * true s'il a été ajouté false sinon
	 **/
	public boolean addPosition(Position position);

	/**
	 * avec merge on permet d'attacher un objet pour pouvoir faire des modids
	 * sur lui elle prend en paramétre un objet de type position et retourne une
	 * valeur boolean
	 **/
	public boolean upTodatePosition(Position position);

	/**
	 * avec la méthode remove on supprime un objet et on le détache du context
	 * de persistence il n'est plus géré par le GE
	 **/
	public boolean removePosition(Position position);

	/** la méthode findPositionById permet de rechercher une position par son id **/
	public Position findPositionById(int id);

	/**
	 * La méthode findAllPosition permet de retourner une liste de position en
	 * creant une requéte avec JPQL
	 **/
	public List<Position> findAllPositions();
}

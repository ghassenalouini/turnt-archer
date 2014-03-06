package tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Trader;

@Local
public interface TraderServicesLocal {
	/**
	 * la méthode finTraderbyId permet de retourner un un trader en lui donnant
	 * en paramétre un id
	 **/
	public Trader findTraderbyId(int id);

	/**
	 * La méthode addTrader permet d'attacher un objet entity avec persist pour
	 * pouvoir étre géré par le GE
	 **/
	public boolean addTrader(Trader trader);

	/**
	 * La méthode update permet de mettre a jour un objet entity détaché avec
	 * merge pour d'eventuels modif
	 **/
	public boolean updateTrader(Trader trader);

	/**
	 * la méthoe remove permet de supprimer un objet entité trader et le
	 * détacher
	 **/
	public boolean removeTrader(Trader trader);

	/**
	 * La Méthode findAllTraders permet de retourner une liste de trader avec
	 * une requéte créée avec JPQL
	 **/
	public List<Trader> findAllTraders();

}

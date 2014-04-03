package tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Trader;

@Local
public interface TraderServicesLocal {
	/**
	 * la m�thode finTraderbyId permet de retourner un un trader en lui donnant
	 * en param�tre un id
	 **/
	public Trader findTraderbyId(int id);

	/**
	 * La m�thode addTrader permet d'attacher un objet entity avec persist pour
	 * pouvoir �tre g�r� par le GE
	 **/
	public boolean addTrader(Trader trader);

	/**
	 * La m�thode update permet de mettre a jour un objet entity d�tach� avec
	 * merge pour d'eventuels modif
	 **/
	public boolean updateTrader(Trader trader);

	/**
	 * la m�thoe remove permet de supprimer un objet entit� trader et le
	 * d�tacher
	 **/
	public boolean removeTrader(Trader trader);

	/**
	 * La M�thode findAllTraders permet de retourner une liste de trader avec
	 * une requ�te cr��e avec JPQL
	 **/
	public List<Trader> findAllTraders();

}

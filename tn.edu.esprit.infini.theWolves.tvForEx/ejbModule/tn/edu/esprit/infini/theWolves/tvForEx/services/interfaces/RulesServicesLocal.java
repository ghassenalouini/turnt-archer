package tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Rules;

@Local
public interface RulesServicesLocal {
	/**
	 * la m�thode addRules avec persist permet d'attacher un objet d'entit� pour
	 * qu'il puisse �tre g�r� par le GE et ajout� � la base
	 **/
	boolean addRules(Rules rules);

	/**
	 * La m�thode removeRules permet de d�tacher un objet entity et le supprimer
	 * de la base
	 **/
	boolean removeRules(Rules rules);

	/**
	 * la m�thode updateRules permet de faire un merge sur objet entit� et
	 * l'attacher pour pouvoir realiser des modifs sur lui
	 **/
	boolean updateRules(Rules rules);

	/**
	 * La m�thode findRulesById permet de retourner un objet rules en lui
	 * donnant en param�tre un id
	 **/
	Rules findRuleById(int id);

	/**
	 * la m�thode findAllRules permet de retourner une liste de rules en creant
	 * une requ�te JPQL
	 **/
	List<Rules> findAllRules();
}

package tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Rules;

@Local
public interface RulesServicesLocal {
	/**
	 * la méthode addRules avec persist permet d'attacher un objet d'entité pour
	 * qu'il puisse étre géré par le GE et ajouté à la base
	 **/
	boolean addRules(Rules rules);

	/**
	 * La méthode removeRules permet de détacher un objet entity et le supprimer
	 * de la base
	 **/
	boolean removeRules(Rules rules);

	/**
	 * la méthode updateRules permet de faire un merge sur objet entité et
	 * l'attacher pour pouvoir realiser des modifs sur lui
	 **/
	boolean updateRules(Rules rules);

	/**
	 * La méthode findRulesById permet de retourner un objet rules en lui
	 * donnant en paramétre un id
	 **/
	Rules findRuleById(int id);

	/**
	 * la méthode findAllRules permet de retourner une liste de rules en creant
	 * une requéte JPQL
	 **/
	List<Rules> findAllRules();
}

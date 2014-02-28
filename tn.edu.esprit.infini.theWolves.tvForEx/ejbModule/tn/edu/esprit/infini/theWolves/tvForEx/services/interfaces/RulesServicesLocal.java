package tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Rules;

@Local
public interface RulesServicesLocal {

	boolean addRules(Rules rules);

	boolean removeRules(Rules rules);

	boolean updateRules(Rules rules);

	Rules findRuleById(int id);

	List<Rules> findAllRules();
}

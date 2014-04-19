package tn.edu.esprit.infini.theWolves.tvForEx.facadeRemote.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Rules;


@Remote
public interface RulesFacadeRemote {

	boolean addRules(Rules rules);

	boolean removeRules(Rules rules);

	boolean updateRules(Rules rules);

	Rules findRuleById(int id);

	List<Rules> findAllRules();
}

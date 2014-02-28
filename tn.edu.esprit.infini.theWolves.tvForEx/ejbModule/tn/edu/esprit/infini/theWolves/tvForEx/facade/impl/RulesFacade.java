package tn.edu.esprit.infini.theWolves.tvForEx.facade.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Rules;
import tn.edu.esprit.infini.theWolves.tvForEx.facade.interfaces.RulesFacadeRemote;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.RulesServicesLocal;

/**
 * Session Bean implementation class RulesFacade
 */
@Stateless
@LocalBean
public class RulesFacade implements RulesFacadeRemote {

	@EJB
	RulesServicesLocal rulesServicesLocal;
	
    /**
     * Default constructor. 
     */
    public RulesFacade() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean addRules(Rules rules) {		
		return rulesServicesLocal.addRules(rules);
	}

	@Override
	public boolean removeRules(Rules rules) {
		return rulesServicesLocal.removeRules(rules);
	}

	@Override
	public boolean updateRules(Rules rules) {
		return rulesServicesLocal.updateRules(rules);
	}

	@Override
	public Rules findRuleById(int id) {
		return rulesServicesLocal.findRuleById(id);
	}

	@Override
	public List<Rules> findAllRules() {
		return rulesServicesLocal.findAllRules();
	}

}

package tn.edu.esprit.infini.theWolves.tvForEx.services.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Rules;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.RulesServicesLocal;

/**
 * Session Bean implementation class RulesServices
 */
@Stateless
@LocalBean
public class RulesServices implements RulesServicesLocal {

	@PersistenceContext
	EntityManager entityManager;
	
    /**
     * Default constructor. 
     */
    public RulesServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean addRules(Rules rules) {
		boolean b = false;
		try {
			entityManager.persist(rules);
			b = true;

		} catch (Exception e) {
			System.err.println("error add rule ...");
		}
		return b;
	}

	@Override
	public boolean removeRules(Rules rules) {
	
		boolean b = false;
		try {
			entityManager.remove(entityManager.merge(rules));
			b = true;

		} catch (Exception e) {
			System.err.println("error remove rule ...");
		}
		return b;
	}

	@Override
	public boolean updateRules(Rules rules) {
		boolean b = false;
		try {
			entityManager.merge(rules);
			b = true;

		} catch (Exception e) {
			System.err.println("error update rule ...");
		}
		return b;
	}

	@Override
	public Rules findRuleById(int id) {
		return entityManager.find(Rules.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rules> findAllRules() {
		String jpql = "select r from Rules r";
		return entityManager.createQuery(jpql).getResultList();
	}

}

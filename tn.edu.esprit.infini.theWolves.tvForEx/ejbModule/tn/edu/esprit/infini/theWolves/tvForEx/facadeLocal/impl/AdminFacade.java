package tn.edu.esprit.infini.theWolves.tvForEx.facadeLocal.impl;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Administrator;
import tn.edu.esprit.infini.theWolves.tvForEx.facadeLocal.interfaces.AdminFacadeLocal;

/**
 * Session Bean implementation class AdminFacade
 */
@Stateless
@LocalBean
public class AdminFacade implements AdminFacadeLocal {

	@PersistenceContext
	private EntityManager entityManager;
	
    /**
     * Default constructor. 
     */
    public AdminFacade() {
        // TODO Auto-generated constructor stub
    }
    
    public Administrator loginAdmin(String login, String password){
    	
    	Administrator found = null;
		String jpql = "select a from Administrator a where a.login=:login and a.password=:password";
		
		Query query= entityManager.createQuery(jpql);
		
		query.setParameter("login", login);
		query.setParameter("password", password);
		
		try{
			
			found =(Administrator) query.getSingleResult();
		
		}catch(Exception ex){
		}
		
		return found;
    }

	@Override
	public boolean addAdmin(Administrator administrator) {
		boolean b = false;
		try {
			entityManager.persist(administrator);
			b = true;

		} catch (Exception e) {
			System.err.println("error add admin en facade locale ...");
		}
		return b;
		
	}

}

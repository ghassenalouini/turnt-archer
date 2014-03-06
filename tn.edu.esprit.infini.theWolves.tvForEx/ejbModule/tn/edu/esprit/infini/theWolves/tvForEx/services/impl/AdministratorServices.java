package tn.edu.esprit.infini.theWolves.tvForEx.services.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Administrator;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.AdministratorServicesLocal;

/**
 * Session Bean implementation class AdministratorServices
 */
@Stateless
@LocalBean
public class AdministratorServices implements AdministratorServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;
	
    /**
     * Default constructor. 
     */
    public AdministratorServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean addAdmin(Administrator administrator) {
		boolean b = false;
		try {
			entityManager.persist(administrator);
			b = true;

		} catch (Exception e) {
			System.err.println("error add admin ...");
		}
		return b;
		
	}

	@Override
	public boolean removeAdmin(Administrator administrator) {
		boolean b = false;
		try {
			entityManager.remove(administrator);
			b = true;

		} catch (Exception e) {
			System.err.println("error remove admin ...");
		}
		return b;
	}

	@Override
	public boolean updateAdmin(Administrator administrator) {
		boolean b = false;
		try {
			entityManager.merge(administrator);
			b = true;

		} catch (Exception e) {
			System.err.println("error update admin ...");
		}
		return b;
	}

	@Override
	public Administrator findAdminById(int id) {
		return entityManager.find(Administrator.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Administrator> findAllAdmins() {
		String jpql = "select a from Administrator a";
		return entityManager.createQuery(jpql).getResultList();
	
	}

}

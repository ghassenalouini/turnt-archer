package tn.edu.esprit.infini.theWolves.tvForEx.facade.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Administrator;
import tn.edu.esprit.infini.theWolves.tvForEx.facade.interfaces.AdministratorFacadeRemote;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.AdministratorServicesLocal;

/**
 * Session Bean implementation class AdministratorFacade
 */
@Stateless
@LocalBean
public class AdministratorFacade implements AdministratorFacadeRemote {
	@EJB
	AdministratorServicesLocal administratorServicesLocal;
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public AdministratorFacade() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addAdmin(Administrator administrator) {
		return administratorServicesLocal.addAdmin(administrator);
	}

	@Override
	public boolean removeAdmin(Administrator administrator) {
		return administratorServicesLocal.removeAdmin(administrator);
	}

	@Override
	public boolean updateAdmin(Administrator administrator) {
		return administratorServicesLocal.updateAdmin(administrator);
	}

	@Override
	public Administrator findAdminById(int id) {
		return administratorServicesLocal.findAdminById(id);
	}

	@Override
	public List<Administrator> findAllAdmins() {
		return administratorServicesLocal.findAllAdmins();
	}

	@Override
	public Administrator logInAdmin(String login, String password) {

		String jpql = "select c from Administrator c where c.login=:param1 and c.password=:param2";
		Administrator b ;

		Query query = (Query) entityManager.createQuery(jpql);
		query.setParameter("param1", login);
		query.setParameter("param2", password);

		
			 b = (Administrator) query.getSingleResult();
		

		return b;

	}

}

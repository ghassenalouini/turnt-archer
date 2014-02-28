package tn.edu.esprit.infini.theWolves.tvForEx.facade.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Administrator;
import tn.edu.esprit.infini.theWolves.tvForEx.facade.interfaces.AdministratorFacadeRemote;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.AdministratorServicesLocal;

/**
 * Session Bean implementation class AdministratorFacade
 */
@Stateless
@LocalBean
public class AdministratorFacade implements AdministratorFacadeRemote {

	AdministratorServicesLocal administratorServicesLocal;
	
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
	public boolean updateCurrency(Administrator administrator) {
		return administratorServicesLocal.updateCurrency(administrator);
	}

	@Override
	public Administrator findAdminById(int id) {
		return administratorServicesLocal.findAdminById(id);
	}

	@Override
	public List<Administrator> findAllAdmins() {
		return administratorServicesLocal.findAllAdmins();
	}

	
    
    
    

}

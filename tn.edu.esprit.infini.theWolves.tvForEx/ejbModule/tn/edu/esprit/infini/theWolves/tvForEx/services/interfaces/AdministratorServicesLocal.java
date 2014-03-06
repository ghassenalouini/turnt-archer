package tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Administrator;


@Local
public interface AdministratorServicesLocal {
	
	
	boolean addAdmin(Administrator administrator);

	boolean removeAdmin(Administrator administrator);

	boolean updateAdmin(Administrator administrator);

	Administrator findAdminById(int id);

	List<Administrator> findAllAdmins();

}

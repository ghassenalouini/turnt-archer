package tn.edu.esprit.infini.theWolves.tvForEx.facadeRemote.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Administrator;

@Remote
public interface AdministratorFacadeRemote {

	
	public boolean addAdmin(Administrator administrator);

	public boolean removeAdmin(Administrator administrator);

	public boolean updateAdmin(Administrator administrator);

	public Administrator findAdminById(int id);

	public List<Administrator> findAllAdmins();

	public Administrator logInAdmin(String login, String password);

}

package tn.edu.esprit.infini.theWolves.tvForEx.facadeLocal.interfaces;

import javax.ejb.Local;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Administrator;

@Local
public interface AdminFacadeLocal  {
	
	public Administrator loginAdmin(String login, String password);
	
	public boolean addAdmin(Administrator administrator);
	

}

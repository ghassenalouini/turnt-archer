package tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces;

import javax.ejb.Remote;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Bank;


@Remote
public interface BankServicesRemote {
	
	public boolean addBank(Bank bank);


}

package tn.edu.esprit.infini.theWolves.tvForEx.services.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Bank;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.BankServicesRemote;


@Stateless
public class BankServices implements BankServicesRemote {
	
	
	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public boolean addBank(Bank bank) {
		boolean b = false;
		try {
			entityManager.persist(bank);
			b = true;

		} catch (Exception e) {
			System.err.println("emmm haw fibali ...");
		}
		return b;
		
		
	}
	
	

}

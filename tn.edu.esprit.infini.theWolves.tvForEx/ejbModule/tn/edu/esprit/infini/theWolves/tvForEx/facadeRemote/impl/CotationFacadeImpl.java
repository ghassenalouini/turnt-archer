package tn.edu.esprit.infini.theWolves.tvForEx.facadeRemote.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Context;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Administrator;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Bank;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Cotation;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Customer;
import tn.edu.esprit.infini.theWolves.tvForEx.facadeRemote.interfaces.CotationFacadeRemote;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.CotationServicesLocal;

/**
 * Session Bean implementation class CotationFacadeImpl
 */
@Stateless
@LocalBean
public class CotationFacadeImpl implements CotationFacadeRemote {

	
	@EJB
	private CotationServicesLocal cotationServiceLocal;
	@PersistenceContext
	private EntityManager entityManager;

	
	
    /**
     * Default constructor. 
     */
    public CotationFacadeImpl() {
        // TODO Auto-generated constructor stub
    }



	public Cotation findcotationByBankCurrency(Customer customer,
			Currency currency) {
		return cotationServiceLocal.findcotationByBankCurrency(customer, currency);
	}



	public boolean addCotation(Cotation cotation) {
		return cotationServiceLocal.addCotation(cotation);
	}



	public boolean removeCotation(Cotation cotatio) {
		return cotationServiceLocal.removeCotation(cotatio);
	}



	public List<Cotation> findcotationByBank(Bank bank) {
		return cotationServiceLocal.findcotationByBank(bank);
	}



	public boolean updateCotation(Cotation cotation) {
		return cotationServiceLocal.updateCotation(cotation);
	}



	public List<Administrator> findAllCotation() {
		return cotationServiceLocal.findAllCotation();
	}



	public Cotation findCotationByCurrecy(Currency currency) {
		return cotationServiceLocal.findCotationByCurrecy(currency);
	}

    
    
    
    
}

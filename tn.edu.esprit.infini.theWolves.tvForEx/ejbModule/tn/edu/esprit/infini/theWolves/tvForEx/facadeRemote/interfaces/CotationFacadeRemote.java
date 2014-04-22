package tn.edu.esprit.infini.theWolves.tvForEx.facadeRemote.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Administrator;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Bank;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Cotation;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Customer;

@Remote
public interface CotationFacadeRemote {
	
	public Cotation findcotationByBankCurrency(Customer customer,
			Currency currency);

	boolean addCotation(Cotation cotation);

	boolean removeCotation(Cotation cotatio);

	public List<Cotation> findcotationByBank(Bank bank);
	boolean updateCotation(Cotation cotation);
	public List<Administrator> findAllCotation();
	public Cotation findCotationByCurrecy(Currency currency);

}

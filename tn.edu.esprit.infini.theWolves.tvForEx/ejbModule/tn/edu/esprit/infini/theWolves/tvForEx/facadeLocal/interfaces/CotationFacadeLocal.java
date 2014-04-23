package tn.edu.esprit.infini.theWolves.tvForEx.facadeLocal.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Bank;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Cotation;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Customer;

@Local
public interface CotationFacadeLocal {

	public Cotation findcotationByBankCurrency(Customer customer,
			Currency currency);

	boolean addCotation(Cotation cotation);

	boolean removeCotation(Cotation cotatio);

	public List<Cotation> findcotationByBank(Bank bank);

	boolean updateCotation (Cotation cotation);

	public List<Cotation> findAllCotation();

	public Cotation findCotationByCurrecy(Currency currency);

}

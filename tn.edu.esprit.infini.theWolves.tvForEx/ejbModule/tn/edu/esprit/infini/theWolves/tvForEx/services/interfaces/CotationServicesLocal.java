package tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces;

import javax.ejb.Local;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Cotation;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Customer;

@Local
public interface CotationServicesLocal {
	public Cotation findcotationByBankCurrency(Customer customer,
			Currency currency);

}

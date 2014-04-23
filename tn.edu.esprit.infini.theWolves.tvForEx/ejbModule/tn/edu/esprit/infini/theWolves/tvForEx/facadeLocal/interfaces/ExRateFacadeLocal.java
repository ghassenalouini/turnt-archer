package tn.edu.esprit.infini.theWolves.tvForEx.facadeLocal.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.ExchangeRate;

@Local
public interface ExRateFacadeLocal {
	
	public ExchangeRate findExchangeRateById(int id);

	public boolean addExchangeRate(ExchangeRate exchangeRate);

	public boolean updateExchangeRate(ExchangeRate exchangeRate);

	public boolean removeExchangeRate(ExchangeRate exchangeRate);

	public List<ExchangeRate> findAllExchangeRate();

}

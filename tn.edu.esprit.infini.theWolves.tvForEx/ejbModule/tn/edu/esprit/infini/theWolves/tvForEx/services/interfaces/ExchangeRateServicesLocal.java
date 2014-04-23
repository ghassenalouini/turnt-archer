package tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.ExchangeRate;

@Local
public interface ExchangeRateServicesLocal {

	public ExchangeRate findExchangeRateById(int id);

	public boolean addExchangeRate(ExchangeRate exchangeRate);

	public boolean updateExchangeRate(ExchangeRate exchangeRate);

	public boolean removeExchangeRate(ExchangeRate exchangeRate);

	public List<ExchangeRate> findAllExchangeRate();
	
	public ExchangeRate findExchangeRateByCurrencyRT(String currencyRT);

}

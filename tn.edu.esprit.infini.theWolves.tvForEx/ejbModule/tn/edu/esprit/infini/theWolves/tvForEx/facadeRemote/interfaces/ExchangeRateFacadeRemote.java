package tn.edu.esprit.infini.theWolves.tvForEx.facadeRemote.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.ExchangeRate;

@Remote
public interface ExchangeRateFacadeRemote {
	
	public ExchangeRate findExchangeRateById(int id);

	public boolean addExchangeRate(ExchangeRate exchangeRate);

	public boolean updateExchangeRate(ExchangeRate exchangeRate);

	public boolean removeExchangeRate(ExchangeRate exchangeRate);

	public List<ExchangeRate> findAllExchangeRate();

}

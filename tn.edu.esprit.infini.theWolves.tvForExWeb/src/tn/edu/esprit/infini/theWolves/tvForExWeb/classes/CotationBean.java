package tn.edu.esprit.infini.theWolves.tvForExWeb.classes;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.ExchangeRate;
import tn.edu.esprit.infini.theWolves.tvForEx.facadeLocal.interfaces.ExRateFacadeLocal;

@ManagedBean
@ViewScoped
public class CotationBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	ExRateFacadeLocal exRateFacadeLocal;

	private ExchangeRate exchangeRate = new ExchangeRate();
	private tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency currency = new tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency();

	
	private List<ExchangeRate> exchangeRates;
	private boolean rendredFrom = false;

	@PostConstruct
	public void init() {

		exchangeRates = exRateFacadeLocal.findAllExchangeRate();
		setRendredFrom(false);

	}

	public ExRateFacadeLocal getExRateFacadeLocal() {
		return exRateFacadeLocal;
	}

	public void setExRateFacadeLocal(ExRateFacadeLocal exRateFacadeLocal) {
		this.exRateFacadeLocal = exRateFacadeLocal;
	}

	public ExchangeRate getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(ExchangeRate exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public List<ExchangeRate> getExchangeRates() {
		return exchangeRates;
	}

	public void setExchangeRates(List<ExchangeRate> exchangeRates) {
		this.exchangeRates = exchangeRates;
	}

	public boolean isRendredFrom() {
		return rendredFrom;
	}

	public void setRendredFrom(boolean rendredFrom) {
		this.rendredFrom = rendredFrom;
	}

	public tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency getCurrency() {
		return currency;
	}

	public void setCurrency(tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency currency) {
		this.currency = currency;
	}

}

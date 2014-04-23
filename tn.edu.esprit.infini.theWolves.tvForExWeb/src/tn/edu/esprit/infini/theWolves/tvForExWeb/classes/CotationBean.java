package tn.edu.esprit.infini.theWolves.tvForExWeb.classes;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Cotation;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.ExchangeRate;
import tn.edu.esprit.infini.theWolves.tvForEx.facadeLocal.interfaces.CotationFacadeLocal;
import tn.edu.esprit.infini.theWolves.tvForEx.facadeLocal.interfaces.ExRateFacadeLocal;

@ManagedBean
@ViewScoped
public class CotationBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private ExRateFacadeLocal exRateFacadeLocal;

	@EJB
	private CotationFacadeLocal cotationFacadeLocal;

	private ExchangeRate exchangeRate = new ExchangeRate();
	private tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency currency = new tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency();
	private Cotation cotation = new Cotation();

	private float UsdTnd;
	private float rate;
	private List<ExchangeRate> exchangeRates;
	private List<Cotation> cotations;
	private boolean rendredFrom = false;

	@PostConstruct
	public void init() {

		cotations = cotationFacadeLocal.findAllCotation();
		exchangeRates = exRateFacadeLocal.findAllExchangeRate();
		setRendredFrom(false);

	}

	public void calculate() {

		for (ExchangeRate e : exchangeRates) {

			rate = 0;
			String currency = e.getCurrencyTR();
			exchangeRate = exRateFacadeLocal
					.findExchangeRateByCurrencyRT(currency);

			for (Cotation c : cotations) {
				if (c.getTransactionPk().getIdCu()
						.equals(exchangeRate.getCurrencyTR())) {

					rate = UsdTnd / e.getRate();
					c.setCotation(rate);
					cotationFacadeLocal.updateCotation(c);
				}

			}

		}

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

	public void setCurrency(
			tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency currency) {
		this.currency = currency;
	}

	public float getUsdTnd() {
		return UsdTnd;
	}

	public void setUsdTnd(float usdTnd) {
		UsdTnd = usdTnd;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public List<Cotation> getCotations() {
		return cotations;
	}

	public void setCotations(List<Cotation> cotations) {
		this.cotations = cotations;
	}

	public Cotation getCotation() {
		return cotation;
	}

	public void setCotation(Cotation cotation) {
		this.cotation = cotation;
	}

}

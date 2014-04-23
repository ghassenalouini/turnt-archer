package tn.edu.esprit.infini.theWolves.tvForExWeb.classes;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;
import tn.edu.esprit.infini.theWolves.tvForEx.facadeLocal.interfaces.CurrFacadeLocal;

@ManagedBean
@ViewScoped
public class CurrencyBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3471379903788017791L;

	@EJB
	CurrFacadeLocal currFacadeLocal;

	private Currency currency = new Currency();
	private List<Currency> currencies;
	private boolean rendredFrom = false;

	@PostConstruct
	public void init() {
		currencies = currFacadeLocal.findAllCurrencies();
		rendredFrom = false;

	}

	public String doNewCurrency() {
		String navigateTo = null;
		rendredFrom = true;
		return navigateTo;
	}

	public String doSaveOrUpdateCurrency() {
		String navigateTo = null;
		currFacadeLocal.updateCurrency(currency);
		currencies = currFacadeLocal.findAllCurrencies();
		rendredFrom = false;
		return navigateTo;
	}

	public String doCancelCurrency() {
		String navigateTo = null;
		currency = new Currency();
		currencies = currFacadeLocal.findAllCurrencies();
		rendredFrom = false;
		return navigateTo;

	}

	public String doDeleteCurrency() {
		String navigateTo = null;
		currFacadeLocal.removeCurrency(currency);
		currencies = currFacadeLocal.findAllCurrencies();
		rendredFrom = false;
		return navigateTo;
	}

	public List<Currency> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(List<Currency> currencies) {
		this.currencies = currencies;
	}

	public boolean isRendredForm() {
		return rendredFrom;
	}

	public void setRendredForm(boolean rendredForm) {
		this.rendredFrom = rendredForm;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

}

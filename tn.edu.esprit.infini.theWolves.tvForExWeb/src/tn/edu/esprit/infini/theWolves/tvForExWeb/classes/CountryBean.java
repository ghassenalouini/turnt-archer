package tn.edu.esprit.infini.theWolves.tvForExWeb.classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Country;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;
import tn.edu.esprit.infini.theWolves.tvForEx.facadeLocal.interfaces.CountFacadeLocal;
import tn.edu.esprit.infini.theWolves.tvForEx.facadeLocal.interfaces.CurrFacadeLocal;

@ManagedBean
@SessionScoped
public class CountryBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1930324604820419207L;
	@EJB
	private CountFacadeLocal countFacadeLocal;
	@EJB
	private CurrFacadeLocal currFacadeLocal;

	private Boolean formDisplayed = false;
	Country country = new Country();
	List<Country> countries;
	private List<SelectItem> selectItemsForCurrency;
	private String selectedCuerrencyLabbel = "-1";

	public CountryBean() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {
		countries = countFacadeLocal.findAllCountries();
		List<Currency> currencies = currFacadeLocal.findAllCurrencies();
		selectItemsForCurrency = new ArrayList<SelectItem>(currencies.size());
		for (Currency currency : currencies) {
			selectItemsForCurrency.add(new SelectItem(currency.getLabel()));
		}
	}

	public String DoSave() {
		String navigateTo = null;
		country.setCurrency(currFacadeLocal
				.findCurrencyByLabbel(selectedCuerrencyLabbel));
		countFacadeLocal.addCountry(country);
		countries = countFacadeLocal.findAllCountries();
		formDisplayed = false;
		return navigateTo;

	}

	public String DoUpdate() {
		String navigateTo = null;
		country.setCurrency(currFacadeLocal
				.findCurrencyByLabbel(selectedCuerrencyLabbel));
		countFacadeLocal.updateCountry(country);
		countries = countFacadeLocal.findAllCountries();
		formDisplayed = false;
		return navigateTo;

	}

	public String DoNew() {
		String navigateTo = null;
		selectedCuerrencyLabbel = "-1";
		formDisplayed = true;
		country = new Country();
		return navigateTo;

	}

	public String DoCancel() {
		String navigateTo = null;
		countries = countFacadeLocal.findAllCountries();
		formDisplayed = false;
		return navigateTo;

	}

	public String DoDelete() {
		String navigateTo = null;
		countFacadeLocal.removeCountry(country);
		countries = countFacadeLocal.findAllCountries();
		formDisplayed = false;

		return navigateTo;

	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	public Boolean getFormDisplayed() {
		return formDisplayed;
	}

	public void setFormDisplayed(Boolean formDisplayed) {
		this.formDisplayed = formDisplayed;
	}

	public String getSelectedCuerrencyLabbel() {
		return selectedCuerrencyLabbel;
	}

	public void setSelectedCuerrencyLabbel(String selectedCuerrencyLabbel) {
		this.selectedCuerrencyLabbel = selectedCuerrencyLabbel;
	}

	public List<SelectItem> getSelectItemsForCurrency() {
		return selectItemsForCurrency;
	}

	public void setSelectItemsForCurrency(
			List<SelectItem> selectItemsForCurrency) {
		this.selectItemsForCurrency = selectItemsForCurrency;
	}

}

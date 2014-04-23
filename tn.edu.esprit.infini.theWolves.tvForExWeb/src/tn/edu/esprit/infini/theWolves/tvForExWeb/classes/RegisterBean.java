package tn.edu.esprit.infini.theWolves.tvForExWeb.classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Bank;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Country;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Customer;
import tn.edu.esprit.infini.theWolves.tvForEx.facadeLocal.interfaces.CountFacadeLocal;
import tn.edu.esprit.infini.theWolves.tvForEx.facadeLocal.interfaces.CustFacadeLocal;

@ManagedBean
@SessionScoped
public class RegisterBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4001499793636211504L;

	@EJB
	private CustFacadeLocal custFacadeLocal;

	@EJB
	private CountFacadeLocal countFacadeLocal;

	Customer customer = new Customer();
	private String swiftCode;
	private int fondPropre;
	private boolean defineType = false;
	private int number;

	private String typeCust;

	private int selectedCountryId = -1;
	private int selectedTypey = -1;
	private List<SelectItem> selectedItemsForCountries;

	public RegisterBean() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {

		List<Country> countries = countFacadeLocal.findAllCountries();
		selectedItemsForCountries = new ArrayList<SelectItem>(countries.size());

		for (Country c : countries) {
			selectedItemsForCountries
					.add(new SelectItem(c.getId(), c.getName()));
		}

	}

	public void type() {

		defineType = true;

	}

	public void ty() {

	}

	public String Register() {

		String navigateTo = null;
		customer.setCountry(countFacadeLocal.findCountryById(selectedCountryId));
		if (selectedTypey == 2) {

			((Bank) customer).setFond_propre(fondPropre);
			((Bank) customer).setSwift_code(swiftCode);
		}

		custFacadeLocal.addCustomer(customer);
		System.out.println("ajout");
		customer = new Customer();
		defineType = false;
		return navigateTo;

	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getSelectedCountryId() {
		return selectedCountryId;
	}

	public void setSelectedCountryId(int selectedCountryId) {
		this.selectedCountryId = selectedCountryId;
	}

	public List<SelectItem> getSelectedItemsForCountries() {
		return selectedItemsForCountries;
	}

	public void setSelectedItemsForCountries(
			List<SelectItem> selectedItemsForCountries) {
		this.selectedItemsForCountries = selectedItemsForCountries;
	}

	public boolean isDefineType() {
		return defineType;
	}

	public void setDefineType(boolean defineType) {
		this.defineType = defineType;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getSwiftCode() {
		return swiftCode;
	}

	public void setSwiftCode(String swiftCode) {
		this.swiftCode = swiftCode;
	}

	public float getFondPropre() {
		return fondPropre;
	}

	public void setFondPropre(int fondPropre) {
		this.fondPropre = fondPropre;
	}

	public int getSelectedTypey() {
		return selectedTypey;
	}

	public void setSelectedTypey(int selectedTypey) {
		this.selectedTypey = selectedTypey;
	}

	public String getTypeCust() {
		return typeCust;
	}

	public void setTypeCust(String typeCust) {
		this.typeCust = typeCust;
	}

}

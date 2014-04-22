package tn.edu.esprit.infini.theWolves.tvForExWeb.classes;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.CentralBank;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Corporate;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Customer;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Trader;
import tn.edu.esprit.infini.theWolves.tvForEx.facadeLocal.interfaces.CustFacadeLocal;

@ManagedBean
@SessionScoped
public class AuthentificationCustomerBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private CustFacadeLocal custFacadeLocal;

	private Customer customer = new Customer();
	private int number;
	private boolean defineType;
	private boolean loggedIn;
	private String userType;


	public String doLoginCustomer() {
		String navigateTo = null;
		customer = custFacadeLocal.loginCustomer(customer.getLogin(),
				customer.getPassword());
		if (customer != null) {

			loggedIn = true;

			if (customer instanceof Trader) {
				System.out.println("login customer");
				userType = "Trader";
				navigateTo = "/Pages/Platfrom/AdminHome";

			} else if (customer instanceof Corporate) {
				System.out.println("login corporate");
				userType = "Corporate";
				navigateTo = "/Pages/Platfrom/AdminHome";
				userType = "";

			} else if (customer instanceof CentralBank) {
				System.out.println("login central bank");
				userType = "Central Bank";
				navigateTo = "/Pages/Platfrom/AdminHome";
			}

		} else {
			FacesMessage message = new FacesMessage("Bad credentials");
			FacesContext.getCurrentInstance().addMessage(
					"login_submit:submit_id", message);
			loggedIn = false;
			navigateTo = null;
		}
		return navigateTo;
	}

	public String logout() {
		String navigateTo = null;
		
		customer = new Customer();
		
		navigateTo="/WelcomeTvForex?faces-redirect=true";
		
		return navigateTo;
	}

	public void type() {
		if (number == 2) {
			setDefineType(true);
		}
	}


	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public boolean isDefineType() {
		return defineType;
	}

	public void setDefineType(boolean defineType) {
		this.defineType = defineType;
	}

}

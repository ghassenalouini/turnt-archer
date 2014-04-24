package tn.edu.esprit.infini.theWolves.tvForExWeb.classes;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Customer;
import tn.edu.esprit.infini.theWolves.tvForEx.facadeLocal.interfaces.CustomerFacadeLocal;

@ManagedBean
@ViewScoped
public class CustomerBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private CustomerFacadeLocal customerFacadeLocal;

	private Customer customer;
	private boolean rendredFrom = false;
	private List<Customer> filteredCategories;

	public CustomerBean() {

	}

	@PostConstruct
	public void init() {
		customer = new Customer();
		filteredCategories = customerFacadeLocal.findWaitingCustomers();
		rendredFrom = false;
	}

	public String confirmCustomer() {
		String navigateTo = null;
		customer.setState("Verified");
		customerFacadeLocal.updateCustomer(customer);
		filteredCategories = customerFacadeLocal.findWaitingCustomers();
		navigateTo = "Pages/Platfrom/Administrator/confirmCustomer";
		return navigateTo;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Customer> getFilteredCategories() {
		return filteredCategories;
	}

	public void setFilteredCategories(List<Customer> filteredCategories) {
		this.filteredCategories = filteredCategories;
	}

	public boolean isRendredFrom() {
		return rendredFrom;
	}

	public void setRendredFrom(boolean rendredFrom) {
		this.rendredFrom = rendredFrom;
	}

}

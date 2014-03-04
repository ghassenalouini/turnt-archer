package tn.edu.esprit.infini.theWolves.tvForEx.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Country
 * 
 */

@Entity
public class Country implements Serializable {

	private int id;
	private String name;
	private String Code;
	private static final long serialVersionUID = 1L;

	private Currency currency;
	private List<Customer> customers;

	@ManyToOne
	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Country() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return this.Code;
	}

	public void setCode(String Code) {
		this.Code = Code;
	}

	@OneToMany(mappedBy = "country")
	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

}

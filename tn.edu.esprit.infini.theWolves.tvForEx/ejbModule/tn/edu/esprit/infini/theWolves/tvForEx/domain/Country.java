package tn.edu.esprit.infini.theWolves.tvForEx.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * La classe country contient 3attributs id(auto_incrementable),name(nom du
 * pays) et code(code du pays). relation avec la classe currency et relation
 * avec la classe custommer
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

	/** un parametre par defaut de la classe country **/
	public Country() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	/**
	 * un constructeur de la classe country qui prend en parametre name(String)
	 * et code(String)
	 **/
	public Country(String name, String code) {
		super();
		this.name = name;
		Code = code;
	}

	/**
	 * un constructeur de la classe country qui prend en parametre
	 * id(int),name(String),code(String),currency(Currency,liste de custommer
	 * (List<Customer>)
	 **/
	public Country(String name, String code, Currency currency) {

		this.name = name;
		this.Code = code;
		this.currency = currency;

	}

	/** modifier l'id d'un pays et prend en parametre un entier (int) **/
	public void setId(int id) {
		this.id = id;
	}

	/** retourne le nom d'un pays (String) **/
	public String getName() {
		return this.name;
	}

	/**
	 * modifier le nom d'un pays et prend en parametre un champ de type (String)
	 **/
	public void setName(String name) {
		this.name = name;
	}

	/** retourne le code d'un pays qui est de type (String) **/
	public String getCode() {
		return this.Code;
	}

	/** modifier le code d'un pays et prend en paramtre un (String) **/
	public void setCode(String Code) {
		this.Code = Code;
	}

	/**
	 * retourne la liste des custommer qui apartiennent a ce pays et retourne
	 * une list<Customer>
	 **/
	@OneToMany(mappedBy = "country")
	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	/**
	 * public void setCustomers(List<Customer> customers) { this.customers =
	 * customers; }
	 * 
	 * /** retourne la devise du pays
	 **/

	@ManyToOne
	public Currency getCurrency() {
		return currency;
	}

	/** modifier la devise du pays **/
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
}

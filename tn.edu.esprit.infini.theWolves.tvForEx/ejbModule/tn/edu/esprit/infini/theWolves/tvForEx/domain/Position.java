package tn.edu.esprit.infini.theWolves.tvForEx.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Position
 * 
 */
@Entity
public class Position implements Serializable {

	private int id;
	private float credit;
	private float averageCost;
	private static final long serialVersionUID = 1L;

	private Customer customer;
	private Currency currency;

	public Position() {

	}

	public Position(Customer customer, Currency currency, float amount) {

		this.customer = customer;
		this.currency = currency;
		this.credit = amount;
	}

	public Position(Customer customer, Currency currency, float amount,
			float averageCost) {

		this.customer = customer;
		this.currency = currency;
		this.credit = amount;
		this.averageCost = averageCost;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getCredit() {
		return this.credit;
	}

	public void setCredit(float credit) {
		this.credit = credit;
	}

	@ManyToOne
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@ManyToOne
	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public float getAverageCost() {
		return averageCost;
	}

	public void setAverageCost(float averageCost) {
		this.averageCost = averageCost;
	}

}

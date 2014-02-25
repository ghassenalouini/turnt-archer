package tn.edu.esprit.infini.theWolves.tvForEx.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Transaction
 * 
 */
@Entity
public class Transaction implements Serializable {

	private TransactionPk transactionPk;
	private String type;
	private int amount;
	private float cotation;
	private float cotationBase;
	private static final long serialVersionUID = 1L;

	private Customer customer;
	private Currency currency;
	private Customer customerCross;
	private Currency currencyCross;

	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@EmbeddedId
	public TransactionPk getTransactionPk() {
		return transactionPk;
	}

	public void setTransactionPk(TransactionPk transactionPk) {
		this.transactionPk = transactionPk;
	}

	@ManyToOne
	@JoinColumn(name = "idCustomer", referencedColumnName = "id", updatable = false, insertable = false)
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@ManyToOne
	@JoinColumn(name = "idCurrency", referencedColumnName = "id", updatable = false, insertable = false)
	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Transaction(String type, int amount, Customer customer,
			Currency currency) {
		super();
		this.type = type;
		this.amount = amount;
		this.customer = customer;
		this.currency = currency;
		this.transactionPk = new TransactionPk(customer.getId(),
				currency.getId());
	}

	public float getCotation() {
		return cotation;
	}

	public void setCotation(float cotation) {
		this.cotation = cotation;
	}

	public Transaction(float cotation, Customer customer, Currency currency) {
		super();
		this.transactionPk = new TransactionPk(customer.getId(),
				currency.getId());
		this.type = "bid";
		this.cotation = cotation;
		this.customer = customer;
		this.currency = currency;
	}

	public Transaction(String type, int amount, Customer customer,
			Currency currency, float cotation) {
		super();
		this.type = type;
		this.amount = amount;
		this.cotation = cotation;
		this.customer = customer;
		this.currency = currency;
		this.transactionPk = new TransactionPk(customer.getId(),
				currency.getId());
	}

	@ManyToOne
	@JoinColumn(name = "customerCross_id")
	public Customer getCustomerCross() {
		return customerCross;
	}

	public void setCustomerCross(Customer customerCross) {
		this.customerCross = customerCross;
	}

	@ManyToOne
	@JoinColumn(name = "CurrencyCross_id")
	public Currency getCurrencyCross() {
		return currencyCross;
	}

	public void setCurrencyCross(Currency currencyCross) {
		this.currencyCross = currencyCross;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Transaction(String type, int amount, float cotation,
			Customer customer, Currency currency, Customer customerCross,
			Currency currencyCross) {
		super();
		this.transactionPk = new TransactionPk(customer.getId(),
				currency.getId());
		this.type = type;
		this.amount = amount;
		this.cotation = cotation;
		this.customerCross = customerCross;
		this.currencyCross = currencyCross;
	}

	public float getCotationBase() {
		return cotationBase;
	}

	public void setCotationBase(float cotationBase) {
		this.cotationBase = cotationBase;
	}

	public Transaction(String type, int amount, float cotation,
			float cotationBase, Customer customer, Currency currency,
			Customer customerCross, Currency currencyCross) {
		super();
		this.type = type;
		this.amount = amount;
		this.cotation = cotation;
		this.cotationBase = cotationBase;
		this.customer = customer;
		this.currency = currency;
		this.customerCross = customerCross;
		this.currencyCross = currencyCross;
		this.transactionPk = new TransactionPk(customer.getId(),
				currency.getId());

	}

}

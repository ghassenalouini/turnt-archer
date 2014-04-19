package tn.edu.esprit.infini.theWolves.tvForEx.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Transaction
 * 
 */
@Entity
public class Transaction implements Serializable {

	private int id;
	private String type;
	private int amount;
	private float cotation;
	private int ctrAmout;
	private float cotationBase;
	private int ccyBasAmount;
	
	//private Bank bank;

	private TransactionPk transactionPk;
	private Currency currencyCross;
	private Customer customerCross;
	private TradeSerie tradeSerie;

	private static final long serialVersionUID = 1L;

	public Transaction() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Deal_Ref")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Embedded
	public TransactionPk getTransactionPk() {
		return transactionPk;
	}

	public void setTransactionPk(TransactionPk transactionPk) {
		this.transactionPk = transactionPk;
	}

	@ManyToOne
	@JoinColumn(name = "CtrCcy")
	public Currency getCurrencyCross() {
		return currencyCross;
	}

	public void setCurrencyCross(Currency currencyCross) {
		this.currencyCross = currencyCross;
	}

	@Column(name = "Sens")
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "CcyAmount")
	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Column(name = "CcyRate")
	public float getCotation() {
		return cotation;
	}

	public void setCotation(float cotation) {
		this.cotation = cotation;
	}

	@Column(name = "CtrAmount")
	public int getCtrAmout() {
		return ctrAmout;
	}

	public void setCtrAmout(int ctrAmout) {
		this.ctrAmout = ctrAmout;
	}

	@Column(name = "CcyBaseRate")
	public float getCotationBase() {
		return cotationBase;
	}

	public void setCotationBase(float cotationBase) {
		this.cotationBase = cotationBase;
	}

	@Column(name = "CcyBaseAmount")
	public int getCcyBasAmount() {
		return ccyBasAmount;
	}

	public void setCcyBasAmount(int ccyBasAmount) {
		this.ccyBasAmount = ccyBasAmount;
	}

	//@Column(name = "Bank")
	//public int getBank() {
	//	return bank;
	//}



	@ManyToOne
	@JoinColumn(name = "CtrCustomer")
	public Customer getCustomerCross() {
		return customerCross;
	}

	public void setCustomerCross(Customer customerCross) {
		this.customerCross = customerCross;
	}

	@ManyToOne
	public TradeSerie getTradeSerie() {
		return tradeSerie;
	}

	public void setTradeSerie(TradeSerie tradeSerie) {
		this.tradeSerie = tradeSerie;
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

	public Transaction(String type, int amount, float cotation,
			float cotationBase, Customer customer, Currency currency,
			Customer customerCross, Currency currencyCross) {
		super();
		this.type = type;
		this.amount = amount;
		this.cotation = cotation;
		this.cotationBase = cotationBase;
		this.customerCross = customerCross;
		this.currencyCross = currencyCross;
		this.transactionPk = new TransactionPk(customer.getId(),
				currency.getId());

	}

	public Transaction(String type, int amount, Customer customer,
			Currency currency) {
		super();
		this.type = type;
		this.amount = amount;
		this.transactionPk = new TransactionPk(customer.getId(),
				currency.getId());
	}

	public Transaction(float cotation, Customer customer, Currency currency) {
		super();
		this.transactionPk = new TransactionPk(customer.getId(),
				currency.getId());
		this.type = "BID";
		this.cotation = cotation;
	}

	public Transaction(String type, int amount, Customer customer,
			Currency currency, float cotation) {
		super();
		this.type = type;
		this.amount = amount;
		this.cotation = cotation;
		this.transactionPk = new TransactionPk(customer.getId(),
				currency.getId());
	}

	public Transaction(Trader trader, String type, int amount,
			Cotation cotation, Bank bank, Currency currencyCross,
			Currency currency, Customer customerCross, TradeSerie tradeSerie) {
		super();
		this.type = type;
		this.amount = amount;

		this.cotationBase = cotation.getCotation();

		//this.bank = transactionPk.getIdCustomer();
		this.transactionPk = new TransactionPk(trader.getId(), currency.getId());
		this.currencyCross = currencyCross;
		this.cotation = cotation.getCotation();
		this.customerCross = customerCross;
		this.tradeSerie = tradeSerie;
	}

}

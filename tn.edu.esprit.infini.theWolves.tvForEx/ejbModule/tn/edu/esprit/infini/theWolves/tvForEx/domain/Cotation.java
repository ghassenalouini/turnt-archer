package tn.edu.esprit.infini.theWolves.tvForEx.domain;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Entity implementation class for Entity: Cotation
 * 
 */
@Entity
public class Cotation implements Serializable {

	@Id
	private int id;
	private float cotation;
	private static final long serialVersionUID = 1L;

	private TransactionPk transactionPk;

	public Cotation() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getCotation() {
		return this.cotation;
	}

	public void setCotation(float cotation) {
		this.cotation = cotation;
	}

	@Embedded
	public TransactionPk getTransactionPk() {
		return transactionPk;
	}

	public void setTransactionPk(TransactionPk transactionPk) {
		this.transactionPk = transactionPk;
	}

}

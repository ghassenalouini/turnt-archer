package tn.edu.esprit.infini.theWolves.tvForEx.domain;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: CentralBank
 * 
 */
@Entity
public class CentralBank extends Customer implements Serializable {

	private float properFund;
	private static final long serialVersionUID = 1L;

	public CentralBank() {
		super();
	}

	public float getProperFund() {
		return this.properFund;
	}

	public void setProperFund(float properFund) {
		this.properFund = properFund;
	}

}

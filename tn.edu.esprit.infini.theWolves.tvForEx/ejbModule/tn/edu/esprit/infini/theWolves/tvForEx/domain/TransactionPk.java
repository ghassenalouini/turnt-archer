package tn.edu.esprit.infini.theWolves.tvForEx.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class TransactionPk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idCustomer;
	private int idCu;
	private Date dateOfTransaction;

	public TransactionPk() {
		// TODO Auto-generated constructor stub
	}

	public int getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	public int getIdCu() {
		return idCu;
	}

	public void setIdCu(int idCu) {
		this.idCu = idCu;
	}

	public TransactionPk(int idCustomer, int idCu) {
		super();
		this.idCustomer = idCustomer;
		this.idCu = idCu;
		this.dateOfTransaction = new Date();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCustomer;
		result = prime * result + idCu;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransactionPk other = (TransactionPk) obj;
		if (idCustomer != other.idCustomer)
			return false;
		if (idCu != other.idCu)
			return false;
		return true;
	}

	public Date getDateOfTransaction() {
		return dateOfTransaction;
	}

	public void setDateOfTransaction(Date dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}

}

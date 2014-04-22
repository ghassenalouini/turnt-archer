package tn.edu.esprit.infini.theWolves.tvForEx.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TransactionPk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idCustomer;
	private String idCu;
	private Date date;

	public TransactionPk() {
		// TODO Auto-generated constructor stub
	}

	@Column(name = "Trader")
	public int getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	@Column(name = "CCY")
	public String getIdCu() {
		return idCu;
	}

	public void setIdCu(String idCu) {
		this.idCu = idCu;
	}

	public TransactionPk(int idCustomer, String idCu) {
		super();
		this.idCustomer = idCustomer;
		this.idCu = idCu;
		this.date = new Date();
	}

	@Column(name = "Deal_Time")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((idCu == null) ? 0 : idCu.hashCode());
		result = prime * result + idCustomer;
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransactionPk other = (TransactionPk) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (idCu == null) {
			if (other.idCu != null)
				return false;
		} else if (!idCu.equals(other.idCu))
			return false;
		if (idCustomer != other.idCustomer)
			return false;
		return true;
	}

	
}

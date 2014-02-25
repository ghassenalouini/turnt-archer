package tn.edu.esprit.infini.theWolves.tvForEx.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Bank
 * 
 */
@Entity
public class Bank extends Customer implements Serializable {

	private int fond_propre;
	private String swift_code;
	private static final long serialVersionUID = 1L;
	private List<Trader> traders;

	public Bank() {
		super();
	}

	public Bank(int fond_propre, String swift_code) {
		super();
		this.fond_propre = fond_propre;
		this.swift_code = swift_code;
	}

	public int getFond_propre() {
		return fond_propre;
	}

	public void setFond_propre(int fond_propre) {
		this.fond_propre = fond_propre;
	}

	public String getSwift_code() {
		return swift_code;
	}

	public void setSwift_code(String swift_code) {
		this.swift_code = swift_code;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@OneToMany(mappedBy = "bank")
	public List<Trader> getTraders() {
		return traders;
	}

	public void setTraders(List<Trader> traders) {
		this.traders = traders;
	}

}

package tn.edu.esprit.infini.theWolves.tvForEx.domain;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: CentralBank
 * 
 */
@Entity
public class CentralBank extends Customer implements Serializable {

	
	private String country;
	private static final long serialVersionUID = 1L;

	public CentralBank() {
		super();
	}
	
	public CentralBank(String name, String login, String password, int phone_number, String adresse_mail, String country) {
		super(name, login, password, phone_number, adresse_mail);
		this.country=country;
		
	}
	

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}

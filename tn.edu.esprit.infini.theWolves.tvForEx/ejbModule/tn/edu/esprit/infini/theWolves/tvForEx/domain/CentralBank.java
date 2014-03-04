package tn.edu.esprit.infini.theWolves.tvForEx.domain;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: CentralBank
 * 
 */
@Entity
public class CentralBank extends Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	public CentralBank() {
		super();
	}

	public CentralBank(String name, String login, String password,
			int phone_number, String adresse_mail) {
		super(name, login, password, phone_number, adresse_mail);

	}

}

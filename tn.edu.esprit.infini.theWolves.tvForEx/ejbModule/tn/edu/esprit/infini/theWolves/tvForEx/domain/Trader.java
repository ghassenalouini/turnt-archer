package tn.edu.esprit.infini.theWolves.tvForEx.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Trader
 * 
 */
@Entity
public class Trader implements Serializable {

	private int id;
	private String name;
	private String login;
	private String pswd;
	private static final long serialVersionUID = 1L;

	private Bank bank;

	public Trader() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPswd() {
		return this.pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	@ManyToOne
	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

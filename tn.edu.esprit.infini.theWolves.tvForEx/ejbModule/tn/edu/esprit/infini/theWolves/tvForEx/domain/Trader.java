package tn.edu.esprit.infini.theWolves.tvForEx.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * la classe trader herite de la classe Customer et qui a deux attributs de plus
 * qui sont score(int)" qui est le score dutraderun chiffre de 1 a 9" et le type
 * "qui peut etre soit un tradeur administrateur ou bien un simple traideur"
 **/

@Entity
public class Trader extends Customer implements Serializable {

	private int score;
	private String type;

	private static final long serialVersionUID = 1L;

	private Bank bank;

	/** constructeur par defaut de la classe Trader **/
	public Trader() {
		super();
	}

	/**
	 * Constructeur parametré de la classe Trader String name, String login,
	 * String password, int phone_number, String adresse_mail, int score, String
	 * type, Bank bank)
	 **/
	public Trader(String name, String login, String password, int phone_number,
			String adresse_mail, int score, String type, Bank bank) {
		super(name, login, password, phone_number, adresse_mail);
		this.score = score;
		this.type = type;
		this.bank = bank;
	}

	/** retourne le score du trader **/
	public int getScore() {
		return score;
	}
/****/
	public void setScore(int score) {
		this.score = score;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

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

	/**
	 * c'est le constructeur de la classe bank qui heirte deja de la classe
	 * Custommer qui prend en prametre le nom(String),password(String
	 * ),phone_number(int),adresse_mail(Strin),swift_code(String)
	 **/
	public Bank(String name, String login, String password, int phone_number,
			String adresse_mail, int fond_propre, String swift_code) {
		super(name, login, password, phone_number, adresse_mail);
		this.fond_propre = fond_propre;
		this.swift_code = swift_code;
	}

	/**
	 * constructeur de la classe Bank qui herite de la classe Customer et qui
	 * prend deux parametres:fond_propre(int),swift_code(String)
	 **/
	public Bank(int fond_propre, String swift_code) {
		super();
		this.fond_propre = fond_propre;
		this.swift_code = swift_code;
	}

	/**
	 * c'est le getter de la classe Bank qui retourne le fond_propre d'une
	 * banque de type int
	 **/
	public int getFond_propre() {
		return fond_propre;
	}

	/**
	 * c'est le setter du fond_propre de la classe bank qui prend en parametre
	 * un int
	 **/
	public void setFond_propre(int fond_propre) {
		this.fond_propre = fond_propre;
	}

	/** il retourne le swift_code d'une banque qui est de type String **/
	public String getSwift_code() {
		return swift_code;
	}

	/**
	 * permet de modifier le swift_code d'une banque en prenant enparametre un
	 * String
	 **/
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

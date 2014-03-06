package tn.edu.esprit.infini.theWolves.tvForEx.domain;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: Corporate
 * 
 */
@Entity
public class Corporate extends Customer implements Serializable {

	private String typeActivity;
	private static final long serialVersionUID = 1L;

	/** ceci est un constructeur par defaut qui ne prend aucun parametre **/
	public Corporate() {
		super();

	}

	/**
	 * constructeur de la classe corporate qui herite de customer et qui prend
	 * enparametre
	 * :name(String),login(String),password(String),phone_number(int)
	 * ,adresse_mail(String),typeActivity(String)
	 **/
	public Corporate(String name, String login, String password,
			int phone_number, String adresse_mail, String typeActivity) {
		super(name, login, password, phone_number, adresse_mail);
		this.typeActivity = typeActivity;
	}

	/**
	 * retourne le type d'activité d'un corporate (importateur ou exportateur)
	 * de type String)
	 **/
	public String getTypeActivity() {
		return this.typeActivity;
	}

	/**
	 * modifier le type d'activité d'un corporate et qui prend enparametre un
	 * String (importateur ou exporateur)
	 **/
	public void setTypeActivity(String typeActivity) {
		this.typeActivity = typeActivity;
	}

}

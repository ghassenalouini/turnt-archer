package tn.edu.esprit.infini.theWolves.tvForEx.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Administrator {

	private int id;
	private String nom;
	private String login;
	private String password;
	private String emailAddress;

	private List<Rules> rules;

	/** ceci est un constructeur sans parametre **/
	public Administrator() {
		super();
	}

	/**
	 * ceci est un constructeur qui prend en parametre deux champs dont le
	 * premier est le logine t le deuxieme est le password
	 **/
	public Administrator(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	/**
	 * c'est le getter du parametre id qui est deja unidentifiant unique de la
	 * classe Aministrator et qui est aussi incrementable automatiquement
	 **/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	/** ceci est le setter du parametre id **/
	public void setId(int id) {
		this.id = id;
	}

	// ** c'est la methode get du parametre nom qui retourne comme resultat un
	// champ de type String **/
	public String getNom() {
		return nom;
	}

	/** c'est le setter du parametre nom qui prend en parametre un String **/
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * c'est l getter du parametre login il ne prend rien en parametre et
	 * retourne un String
	 **/
	public String getLogin() {
		return login;
	}

	/**
	 * c'est le setter de la classe Admin du parametre login il prend en
	 * parametre un String
	 **/
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * getter de la classe administrator de l'attribut password et qui retourne
	 * un String
	 **/
	public String getPassword() {
		return password;
	}

	/**
	 * c'est le setter duparametre password de la classe administator qui prend
	 * en parametre un String
	 **/
	public void setPassword(String password) {
		this.password = password;
	}

	/** Getter de l'adresse mail et qui retourne un String **/
	public String getEmailAddress() {
		return emailAddress;
	}

	/** Le setter de l'adresse mail qui prend en parametre un String **/
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * c'est le getter de la liste des rules qui retourne la liste des rules qui
	 * on été placés par l'administrateur
	 **/
	@OneToMany(mappedBy = "administrator")
	public List<Rules> getRules() {
		return rules;
	}

	/**
	 * cette methode prend en parametre une liste de rules et qui permet de
	 * modifier =la liste des rules
	 **/
	public void setRules(List<Rules> rules) {
		this.rules = rules;
	}

}

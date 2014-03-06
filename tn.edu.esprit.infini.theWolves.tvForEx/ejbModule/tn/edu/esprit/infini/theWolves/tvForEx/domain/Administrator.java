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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@OneToMany(mappedBy = "administrator")
	public List<Rules> getRules() {
		return rules;
	}

	public void setRules(List<Rules> rules) {
		this.rules = rules;
	}

}

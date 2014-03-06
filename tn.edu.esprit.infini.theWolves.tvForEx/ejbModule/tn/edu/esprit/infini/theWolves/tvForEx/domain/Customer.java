package tn.edu.esprit.infini.theWolves.tvForEx.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * La classe customer est la classe mére des
 * classes(Bank,CentralBank,Trader,corporate),elle a comme attribut l
 * 'id(int),name(String),login(String),password(String),phone_number(int),adress
 * e _ m a i l ( S t r i n g )
 **/

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Customer implements Serializable {

	private int id;
	private String name;
	private String login;
	private String password;
	private int phone_number;
	private String adresse_mail;

	private List<Position> positions;
	private List<Transaction> transactions;
	private List<Transaction> transactionsCross;
	private Country country;

	private static final long serialVersionUID = 1L;

	/** c'est un constructeur par defaut de la classe Customer **/
	public Customer() {
		super();
	}

	/**
	 * un constructeur de la classe customer qui prend en
	 * parametrename(String),login
	 * (String),password(String),phone_number(int),adresse_mail(String)
	 **/
	public Customer(String name, String login, String password,
			int phone_number, String adresse_mail) {
		super();
		this.name = name;
		this.login = login;
		this.password = password;
		this.phone_number = phone_number;
		this.adresse_mail = adresse_mail;
	}

	/**
	 * retourne l'id de la classe Customer qui joue le role de la clée primaire
	 * dans la table customer et qui est auto-incrementable
	 **/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/** retourne la listedes positions de l'utilisateur pour chaque devise **/

	@OneToMany(mappedBy = "customer")
	public List<Position> getPositions() {
		return positions;
	}

	/**
	 * modifier la position d'un custommeret prend comme parametre uneliste de
	 * position
	 **/
	public void setPositions(List<Position> positions) {
		this.positions = positions;
	}

	/** retourne le numero du telephone du customer (int) **/
	public int getPhone_number() {
		return phone_number;
	}

	/** modifier le numer du telephone du custommer **/
	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}

	/** retourne l'adresse du customer **/
	public String getAdresse_mail() {
		return adresse_mail;
	}

	/**
	 * modifie l'adresse du customer et prend en parametre une nouvelle adresse
	 * de type String
	 **/
	public void setAdresse_mail(String adresse_mail) {
		this.adresse_mail = adresse_mail;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/** retourne le nom du customer (String) **/
	public String getName() {
		return this.name;
	}

	/** modifie le nom du customer etprend en parametre un (String) **/
	public void setName(String name) {
		this.name = name;
	}

	/** retourne le login de l'utilisateur **/
	public String getLogin() {
		return this.login;
	}

	/** modifie le login du customer et prend comme parametre un (String) **/
	public void setLogin(String login) {
		this.login = login;
	}

	/** retourne le password de lutilsiateur **/
	public String getPassword() {
		return this.password;
	}

	/** modifie le password de l'utilisateur **/
	public void setPassword(String password) {
		this.password = password;
	}

	/** modifie la liste des transaction du customer **/
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	/** retourne la liste des transaction en tant que cross **/
	@OneToMany(mappedBy = "customerCross")
	public List<Transaction> getTransactionsCross() {
		return transactionsCross;
	}

	/** modifie la liste des crosstransaction **/
	public void setTransactionsCross(List<Transaction> transactionsCross) {
		this.transactionsCross = transactionsCross;
	}

	/** retourne le pays du customer **/
	@ManyToOne
	public Country getCountry() {
		return country;
	}

	/** modifie le pays du customer **/
	public void setCountry(Country country) {
		this.country = country;
	}

}

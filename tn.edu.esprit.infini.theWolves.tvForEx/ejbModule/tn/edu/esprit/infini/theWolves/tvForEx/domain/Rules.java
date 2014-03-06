package tn.edu.esprit.infini.theWolves.tvForEx.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * la classe roule contient 4 attribut dont le premier est l'id le deuxieme est
 * la date de la creation du rule,le 3éme est le label du rules
 * comme"maxNumberOfTrade" et une valeur de ce dernier l'administrateur peut
 * fixer ces dernierset chaque banque aussi elle doit saisir ses propres rules
 * tout en respectant les les rules poser par l'administrateur
 **/
@Entity
public class Rules {

	private int id;
	Date date;
	private String label;
	private float value;

	private Administrator administrator;
	private Bank bank;

	/** ceci est un constructeur par defaut de la classe administrateur **/
	public Rules() {
		super();
	}

	/**
	 * c'est un constructeur qui prend en parametre la date le label du rul et
	 * se valeur
	 **/
	public Rules(Date date, String label, float value) {
		super();
		this.date = date;
		this.label = label;
		this.value = value;
	}

	/**
	 * C'est un constructeur qui permet d'ajouter un nouveau rule pour un
	 * administrateur
	 **/
	public Rules(Date date, String label, float value,
			Administrator administrator) {
		super();
		this.date = date;
		this.label = label;
		this.value = value;
		this.administrator = administrator;
	}

	/**
	 * c'est un constructeur de la classe rules qui permet de creer une instance
	 * de la classe pour une banque
	 **/
	public Rules(Date date, String label, float value, Bank bank) {
		super();
		this.date = date;
		this.label = label;
		this.value = value;
		this.bank = bank;
	}

	/**
	 * retourne l'id de la classe rules et cet id est lidentifiant unique pour
	 * la table rules et qui est aussi auto incrementable
	 **/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	/** modifie l'id d'un rule **/
	public void setId(int id) {
		this.id = id;
	}

	/** retourne la date de la creation d'une regle **/
	public Date getDate() {
		return date;
	}

	/** modifie la date de la regle en entrant une nouvelle date en parametre **/
	public void setDate(Date date) {
		this.date = date;
	}

	/** retourne le label d'une regle **/
	public String getLabel() {
		return label;
	}

	/** modifie le label dune regle **/
	public void setLabel(String label) {
		this.label = label;
	}

	/** retourne la valeur d'une regle fixée **/
	public float getValue() {
		return value;
	}

	/** permet de modifier la valeur d'une regle **/
	public void setValue(float value) {
		this.value = value;
	}

	/** retourne l'administrateur de la regle **/
	@ManyToOne
	public Administrator getAdministrator() {
		return administrator;
	}

	/** modifie l'administrateur de la regle **/
	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}

	/** retourne la banque qui a fixé cette regle **/
	@ManyToOne
	public Bank getBank() {
		return bank;
	}

	/** modifie la regle de la banque qui a fixé cette regle **/
	public void setBank(Bank bank) {
		this.bank = bank;
	}

}

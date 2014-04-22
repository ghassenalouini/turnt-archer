package tn.edu.esprit.infini.theWolves.tvForEx.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * La classe Currency contient 4 attributs id(int),label(String)
 * "comme [euro,dollarAmericain...], unity(int) qui est l'unit� de chaque devise comme CHF =10 et un dernier attribut initialsqui prend les premiereslettres de chauqe devise comme "
 * euro=>EUR"
 **/

@Entity
public class Currency implements Serializable {

	private String label;
	private int unity;
	private String initials;

	private static final long serialVersionUID = 1L;

	private List<Position> positions;
	private List<Transaction> transactions;
	private List<Transaction> transactionsCross;

	private List<Country> countries;

	/** un parametre par defaut de la classe Currency **/
	public Currency() {
		super();
	}

	@Id
	public String getLabel() {
		return this.label;
	}

	/** modifier le label d'une currencyen entrant un nouveau nom de type String **/
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * retourne un champ de type String qui est l'initial dela currecy comme EUR
	 * pour euro
	 **/
	public String getInitials() {
		return this.initials;
	}

	/** modifier l'initianld'une currency et prends enparametre un String **/
	public void setInitials(String initials) {
		this.initials = initials;
	}

	/**
	 * modifierla liste des transaction d'une currency etprends en parametre une
	 * liste de transaction
	 **/
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	/** retourne la liste des transaction concernant ladevise **/
	@OneToMany(mappedBy = "currencyCross")
	public List<Transaction> getTransactionsCross() {
		return transactionsCross;
	}

	/**
	 * permet de modifier la lister des transaction concernant cette devise en
	 * entranten parametre une liste de transaction
	 **/
	public void setTransactionsCross(List<Transaction> transactionsCross) {
		this.transactionsCross = transactionsCross;
	}

	/** retourne l'unit� de la devise **/
	public int getUnity() {
		return unity;
	}

	/**
	 * permet de modifier la l'unit� de la devise en entrant comme parametre
	 * unentier (int)
	 **/
	public void setUnity(int unity) {
		this.unity = unity;
	}

	/**
	 * un constructeur de laclasse Currency etqui prend en parametre le
	 * label(String) l'unit� (int) et l'initials(String)
	 **/
	public Currency(String label, int unity, String initials) {
		super();
		this.label = label;
		this.unity = unity;
		this.initials = initials;
	}

	/** retourne la liste des positions de la devise **/
	@OneToMany(mappedBy = "currency")
	public List<Position> getPositions() {
		return positions;
	}

	/**
	 * modifier la liste des positions dela devise et prend en parametre une
	 * liste de position
	 **/
	public void setPositions(List<Position> positions) {
		this.positions = positions;
	}

	/** retourne la liste des pays travaillons avec cette currecncy **/
	@OneToMany(mappedBy = "currency")
	public List<Country> getCountries() {
		return countries;
	}

	/** permet modifier la liste des pays travaillons avec cette currency **/
	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

}

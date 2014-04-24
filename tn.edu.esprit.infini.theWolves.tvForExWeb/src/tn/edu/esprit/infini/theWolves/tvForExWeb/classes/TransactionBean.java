package tn.edu.esprit.infini.theWolves.tvForExWeb.classes;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Transaction;
import tn.edu.esprit.infini.theWolves.tvForEx.facadeLocal.interfaces.TransacFacadeLocal;

@ManagedBean
@ViewScoped
public class TransactionBean implements Serializable {

	private static final long serialVersionUID = 1L;

	// Injection du proxy
	@EJB
	private TransacFacadeLocal transacFacadeLocal;

	// Modele
	private Transaction transaction = new Transaction();
	private List<Transaction> transactions;
	private boolean rendredFrom = false;

	public TransactionBean() {
		super();
	}

	// Methode
	@PostConstruct
	public void init() {
		transactions = transacFacadeLocal.findAllTransactions();
	

	}

	// Getters et Setters
	public TransacFacadeLocal getTransacFacadeLocal() {
		return transacFacadeLocal;
	}

	public void setTransacFacadeLocal(TransacFacadeLocal transacFacadeLocal) {
		this.transacFacadeLocal = transacFacadeLocal;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public boolean isRendredFrom() {
		return rendredFrom;
	}

	public void setRendredFrom(boolean rendredFrom) {
		this.rendredFrom = rendredFrom;
	}
}

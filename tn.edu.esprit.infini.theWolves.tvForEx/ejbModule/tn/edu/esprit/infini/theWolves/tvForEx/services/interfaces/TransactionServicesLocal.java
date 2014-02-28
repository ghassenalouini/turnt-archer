package tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Transaction;

@Local
public interface TransactionServicesLocal {
	
	public boolean addTransactionC(Transaction transaction);

	public boolean updateTransaction(Transaction transaction);

	public boolean removeTransaction(Transaction transaction);

	public Transaction findTransactionById(int id);

	public List<Transaction> findAllTransactions();

	

}

package tn.edu.esprit.infini.theWolves.tvForEx.facadeLocal.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Transaction;

@Local
public interface TransacFacadeLocal {

	public boolean addTransactionC(Transaction transaction);

	public boolean updateTransaction(Transaction transaction);

	public boolean removeTransaction(Transaction transaction);

	public Transaction findTransactionById(int id);

	public List<Transaction> findAllTransactions();

}

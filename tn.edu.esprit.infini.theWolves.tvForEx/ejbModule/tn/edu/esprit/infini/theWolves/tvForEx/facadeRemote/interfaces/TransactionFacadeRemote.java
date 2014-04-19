package tn.edu.esprit.infini.theWolves.tvForEx.facadeRemote.interfaces;

import java.util.List;

import javax.ejb.Remote;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Transaction;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Bank;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Customer;

@Remote
public interface TransactionFacadeRemote {

	public boolean addTransactionC(Transaction transaction);

	public boolean updateTransaction(Transaction transaction);

	public boolean removeTransaction(Transaction transaction);

	public Transaction findTransactionById(int id);

	public List<Transaction> findAllTransactions();

	
	
	// ME
	public boolean addTransaction(Customer customer, Currency currency,
			String typeOfTransaction, int amount, float cotation);

	public boolean addCrossTransaction(Customer customer, Customer customerBid,
			Currency currency, Currency currencyCross, String type, int amount,
			float cotation, float cotationBase);

	public boolean createOffer(Bank bank, Currency currency, float cotation);

}

package tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces;

import javax.ejb.Remote;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Customer;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Position;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Transaction;

@Remote
public interface PositionServicesRemote {

public void updatePosition(Transaction transaction);
public Position findPositionByBankCurrency(Customer customer, Currency currency);

}

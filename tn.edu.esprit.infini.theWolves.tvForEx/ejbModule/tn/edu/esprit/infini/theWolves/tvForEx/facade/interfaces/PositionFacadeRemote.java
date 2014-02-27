package tn.edu.esprit.infini.theWolves.tvForEx.facade.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Currency;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Customer;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Position;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Transaction;

@Remote
public interface PositionFacadeRemote {

	public boolean addPosition(Position position);

	public boolean upTodatePosition(Position position);

	public boolean removePosition(Position position);

	public Position findPositionById(int id);

	public List<Position> findAllPositions();

	public void updatePosition(Transaction transaction);

	public Position findPositionByBankCurrency(Customer customer,
			Currency currency);

}

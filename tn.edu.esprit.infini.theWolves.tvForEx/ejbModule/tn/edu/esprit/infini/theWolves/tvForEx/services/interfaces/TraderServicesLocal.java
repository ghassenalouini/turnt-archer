package tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Trader;

@Local
public interface TraderServicesLocal {

	public Trader findTraderbyId(int id);

	public boolean addTrader(Trader trader);

	public boolean updateTrader(Trader trader);

	public boolean removeTrader(Trader trader);

	public List<Trader> findAllTraders();

}

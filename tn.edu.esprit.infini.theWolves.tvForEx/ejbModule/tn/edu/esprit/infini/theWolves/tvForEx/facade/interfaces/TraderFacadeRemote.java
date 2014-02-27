package tn.edu.esprit.infini.theWolves.tvForEx.facade.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Trader;

@Remote
public interface TraderFacadeRemote {

	public Trader findTraderbyId(int id);

	public boolean addTrader(Trader trader);

	public boolean updateTrader(Trader trader);

	public boolean removeTrader(Trader trader);

	public List<Trader> findAllTraders();

}

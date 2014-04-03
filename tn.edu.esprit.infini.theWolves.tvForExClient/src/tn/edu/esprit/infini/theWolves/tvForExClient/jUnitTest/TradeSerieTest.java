package tn.edu.esprit.infini.theWolves.tvForExClient.jUnitTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import junit.framework.Assert;
import junit.framework.AssertionFailedError;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Administrator;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.TradeSerie;
import tn.edu.esprit.infini.theWolves.tvForEx.facade.interfaces.TradeSerieFacadeRemote;

public class TradeSerieTest {
	private TradeSerieFacadeRemote proxy;

	@Before
	public void test() {

		try {
			Context context = new InitialContext();

			String jndiName = "ejb:/tn.edu.esprit.infini.theWolves.tvForEx/TradeSerieFacade!"
					+ TradeSerieFacadeRemote.class.getCanonicalName();

			proxy = (TradeSerieFacadeRemote) context.lookup(jndiName);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	public void itShouldAdd() {
		TradeSerie tradeSerie = new TradeSerie();
		Date d1 = new Date();
		Date d2 = new Date();
		tradeSerie.setCloseDate(d1);
		tradeSerie.setStartDate(d2);
		tradeSerie.setLocation("Loc");
		tradeSerie.setName("Trade1");
		Assert.assertTrue(proxy.addTradeSerie(tradeSerie));
	}

	@Ignore
	@Test
	public void itShouldFindById() {
		TradeSerie tradeSerie = proxy.findTradeSerieById(2);

		Assert.assertEquals("Trade1", tradeSerie.getName());

	}

	@Ignore
	@Test(expected = NullPointerException.class)
	public void itShouldNotFindById() {
		TradeSerie tradeSerie = proxy.findTradeSerieById(5);

		Assert.assertEquals("Trade1", tradeSerie.getName());

	}

	@Ignore
	@Test(expected = junit.framework.ComparisonFailure.class)
	public void itShouldFindByIdAndCompareIt() {

		TradeSerie tradeSerie = proxy.findTradeSerieById(2);
		Assert.assertEquals("Trade11", tradeSerie.getName());
	}
    @Ignore
	@Test
	public void itShouldRemove() {
		TradeSerie tradeSerie=proxy.findTradeSerieById(3);
		Assert.assertTrue(proxy.removeTradeSerie(tradeSerie));
	}
    @Ignore
	@Test(expected = AssertionFailedError.class)
	public void itShouldNotRemoveAdmin() {
		TradeSerie tradeSerie=proxy.findTradeSerieById(3);
		Assert.assertTrue(proxy.removeTradeSerie(tradeSerie));
	}
	@Ignore
	@Test
	public void itShouldUpdate() {
		TradeSerie tradeSerie = proxy.findTradeSerieById(4);
		tradeSerie.setName("Naaame");
		Assert.assertTrue(proxy.updateTradeSerie(tradeSerie));
	}
	@Ignore
	@Test(expected = NullPointerException.class)
	public void itShouldNotUpdate() {
		TradeSerie tradeSerie = proxy.findTradeSerieById(40);
		tradeSerie.setName("Naaame");
		Assert.assertTrue(proxy.updateTradeSerie(tradeSerie));
	}
	@Ignore
	@Test
	public void itShouldDisplayAdmin() {

		List<TradeSerie> serieList = new ArrayList<TradeSerie>();
		serieList = proxy.findAllTradeSeries();

		Assert.assertEquals(1, serieList.size());

	}
	@Ignore
	@Test(expected = AssertionFailedError.class)
	public void itShouldNotDisplayAdmin() {

		List<TradeSerie> serieList = new ArrayList<TradeSerie>();
		serieList = proxy.findAllTradeSeries();

		Assert.assertEquals(10, serieList.size());

	}

}

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
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Rules;
import tn.edu.esprit.infini.theWolves.tvForEx.facade.interfaces.RulesFacadeRemote;

public class RulesTest {
	private RulesFacadeRemote proxy;

	@Before
	public void test() {
		try {
			Context context = new InitialContext();

			String jndiName = "ejb:/tn.edu.esprit.infini.theWolves.tvForEx/RulesFacade!"
					+ RulesFacadeRemote.class.getCanonicalName();

			proxy = (RulesFacadeRemote) context.lookup(jndiName);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    @Ignore
	@Test
	public void itShouldAddRules() {
		Rules r1 = new Rules();
		Date d1 = new Date();
		r1.setDate(d1);
		r1.setLabel("Rules num 1");
		r1.setValue(1F);
		Assert.assertTrue(proxy.addRules(r1));
	}

	@Ignore
	@Test
	public void itShouldFindRuleById() {
		Rules rule = proxy.findRuleById(2);

		Assert.assertEquals("Rules num 1",rule.getLabel());

	}
	@Ignore
	@Test(expected=NullPointerException.class)
	public void itShouldNotFindRuleById() {
		Rules rule = proxy.findRuleById(1);

		Assert.assertEquals("Rules num 1",rule.getLabel());

	}
	@Ignore
	@Test(expected=junit.framework.ComparisonFailure.class)
	public void itShouldFindRuleByIdAndCompareIt() {
		Rules rule = proxy.findRuleById(2);

		Assert.assertEquals("Rules num 12",rule.getLabel());

	}
	@Ignore
	@Test
	public void itShouldRemoveRule() {
		Assert.assertTrue(proxy.removeRules(proxy.findRuleById(1)));
	}
	@Ignore
	@Test(expected=AssertionFailedError.class)
	public void itShouldNotRemoveRule() {
		Assert.assertTrue(proxy.removeRules(proxy.findRuleById(10)));
	}
	@Ignore
	@Test
	public void itShouldUpdateRule() {
		Rules rule = proxy.findRuleById(2);
		rule.setLabel("Rule num 412");
		Assert.assertTrue(proxy.updateRules(rule));
	}
	@Ignore
	@Test
	public void itShouldDisplayrule() {

		List<Rules> RulesList = new ArrayList<Rules>();
		RulesList = proxy.findAllRules();

		Assert.assertEquals(1, RulesList.size());

	}
	@Ignore
	@Test(expected=AssertionFailedError.class)
	public void itShouldNotDisplayrule() {

		List<Rules> RulesList = new ArrayList<Rules>();
		RulesList = proxy.findAllRules();

		Assert.assertEquals(10, RulesList.size());

	}

	
	
	
	
	
	
	

}

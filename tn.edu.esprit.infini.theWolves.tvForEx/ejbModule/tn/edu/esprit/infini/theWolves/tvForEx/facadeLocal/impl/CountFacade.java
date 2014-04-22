package tn.edu.esprit.infini.theWolves.tvForEx.facadeLocal.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Country;
import tn.edu.esprit.infini.theWolves.tvForEx.facadeLocal.interfaces.CountFacadeLocal;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.CountryServicesLocal;

/**
 * Session Bean implementation class CountFacade
 */
@Stateless
@LocalBean
public class CountFacade implements CountFacadeLocal {

	@EJB
	CountryServicesLocal cd;
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public CountFacade() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addCountry(Country country) {
		return cd.addCountry(country);
	}

	@Override
	public boolean removeCountry(Country country) {
		return cd.removeCountry(country);

	}

	@Override
	public boolean updateCountry(Country country) {
		return cd.updateCountry(country);
	}

	@Override
	public Country findCountryById(int id) {
		return cd.findCountryById(id);
	}

	@Override
	public List<Country> findAllCountries() {
		return cd.findAllCountries();
	}

}

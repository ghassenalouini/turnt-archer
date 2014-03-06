package tn.edu.esprit.infini.theWolves.tvForEx.services.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Country;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.CountryServicesLocal;

/**
 * Session Bean implementation class CountryServices
 */
@Stateless
@LocalBean
public class CountryServices implements CountryServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public CountryServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addCountry(Country country) {
		boolean b = false;
		try {
			entityManager.persist(country);
			b = true;

		} catch (Exception e) {
			System.err.println("error add country ...");
		}
		return b;
	}

	@Override
	public boolean removeCountry(Country country) {
		boolean b = false;
		try {
			entityManager.remove(entityManager.merge(country));
			b = true;

		} catch (Exception e) {
			System.err.println("error remove country ...");
		}
		return b;
	}

	@Override
	public boolean updateCountry(Country country) {
		boolean b = false;
		try {
			entityManager.merge(country);
			b = true;

		} catch (Exception e) {
			System.err.println("error update country ...");
		}
		return b;
	}

	@Override
	public Country findCountryById(int id) {

		return entityManager.find(Country.class, id);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Country> findAllCountries() {
		String jpql = "Select c from Country c";
		return entityManager.createQuery(jpql).getResultList();
	}

}

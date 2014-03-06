package tn.edu.esprit.infini.theWolves.tvForEx.facade.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Country;
import tn.edu.esprit.infini.theWolves.tvForEx.facade.interfaces.CountryFacadeRemote;

/**
 * Session Bean implementation class CountryFacade
 */
@Stateless
@LocalBean
public class CountryFacade implements CountryFacadeRemote {

    /**
     * Default constructor. 
     */
	
	@EJB
	CountryFacadeRemote countryFacadeRemote;
	
    public CountryFacade() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean addCountry(Country country) {
		return countryFacadeRemote.addCountry(country);
	}

	@Override
	public boolean removeCountry(Country country) {
		return countryFacadeRemote.removeCountry(country);
		
	}

	@Override
	public boolean updateCountry(Country country) {
		return countryFacadeRemote.updateCountry(country);
	}

	@Override
	public Country findCountryById(int id) {
		return countryFacadeRemote.findCountryById(id);
	}

	@Override
	public List<Country> findAllCountries() {
		return countryFacadeRemote.findAllCountries();
	}

}

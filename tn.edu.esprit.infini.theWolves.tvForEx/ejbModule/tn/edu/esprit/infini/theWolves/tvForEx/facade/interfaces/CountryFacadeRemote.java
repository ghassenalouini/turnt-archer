package tn.edu.esprit.infini.theWolves.tvForEx.facade.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Country;

@Remote
public interface CountryFacadeRemote {

	boolean addCountry(Country country);

	boolean removeCountry(Country country);

	boolean updateCountry(Country country);

	Country findCountryById(int id);

	List<Country> findAllCountries();
}

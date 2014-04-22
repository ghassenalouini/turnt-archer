package tn.edu.esprit.infini.theWolves.tvForEx.facadeLocal.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Country;

@Local
public interface CountFacadeLocal {
	
	boolean addCountry(Country country);

	boolean removeCountry(Country country);

	boolean updateCountry(Country country);

	Country findCountryById(int id);

	List<Country> findAllCountries();

}

package com.crud.demo.service;

import java.util.List;

import com.crud.demo.model.Country;

public interface ICountryService {

	Country create(Country country);

	List<Country> getAll();

	Country update(Country country, final long countryId) throws CountryNotFoundException;

	Country getById(final Long countryId) throws CountryNotFoundException;

	String delete(final Long countryId) throws CountryNotFoundException;

}

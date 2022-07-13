package com.crud.demo.service;

import java.util.List;

import org.springframework.web.client.RestClientException;

import com.crud.demo.model.Country;

public interface ICountryService {

	Country create(Country country) throws CountryBadRequestException;

	List<Country> getAll();

	Country update(Country country, final long countryId) throws CountryNotFoundException;

	Country getById(final Long countryId) throws CountryNotFoundException;
	
	List<?> getExternalCountryList(final String endpoint) throws RestClientException;

	String delete(final Long countryId) throws CountryNotFoundException;

}

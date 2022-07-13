package com.crud.demo.service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.crud.demo.model.Country;
import com.crud.demo.repo.ICountryRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CountryServiceImpl implements ICountryService {

	@Autowired
	private ICountryRepository countryRepository;

	@Override
	public Country create(Country country) throws CountryBadRequestException{
		return countryRepository.save(country);
	}

	@Override
	public List<Country> getAll() {
		return countryRepository.findAll();
	}

	@Override
	public Country update(Country country, long countryId) throws CountryNotFoundException {
		Country localCountry = this.getById(countryId);
		if (!Objects.isNull(localCountry)) {
			return countryRepository.save(country);
		} else {
			throw new CountryNotFoundException(
					CountryNotFoundException.COUNTRY_NOT_FOUND.concat(String.valueOf(countryId)));
		}

	}

	@Override
	public Country getById(Long countryId) throws CountryNotFoundException {
		return countryRepository.findById(countryId).orElseThrow(() -> new CountryNotFoundException(
				CountryNotFoundException.COUNTRY_NOT_FOUND.concat(String.valueOf(countryId))));
	}

	@Override
	public String delete(Long countryId) throws CountryNotFoundException {
		Country localCountry = this.getById(countryId);
		if (!Objects.isNull(localCountry)) {
			countryRepository.deleteById(countryId);
			return localCountry.toString();
		} else {
			throw new CountryNotFoundException(
					CountryNotFoundException.COUNTRY_NOT_FOUND.concat(String.valueOf(countryId)));
		}
	}

	@Override
	public List<?> getExternalCountryList(final String endpoint) throws RestClientException {
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity(endpoint, Object[].class);
		Object[] objects = responseEntity.getBody();

		ObjectMapper mapper = new ObjectMapper();
		return Arrays.stream(objects).map(object -> mapper.convertValue(object, Country.class)).map(Country::getName)
				.collect(Collectors.toList());

	}

}

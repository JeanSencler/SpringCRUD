package com.crud.demo.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.demo.model.Country;
import com.crud.demo.repo.ICountryRepository;

@Service
public class CountryServiceImpl implements ICountryService {

	@Autowired
	private ICountryRepository countryRepository;

	@Override
	public Country create(Country country) {
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

}

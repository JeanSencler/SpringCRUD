package com.crud.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.crud.demo.repo.ICountryRepository;

@SpringBootApplication
public class SpringCrudApplication {

	@Autowired
	ICountryRepository countryRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringCrudApplication.class, args);
	}

}

package com.crud.demo.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CountryNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String COUNTRY_NOT_FOUND = "No Country Found with id ";

	public CountryNotFoundException() {
		super();
	}

	public CountryNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public CountryNotFoundException(String message) {
		super(message);
	}

	public CountryNotFoundException(Throwable cause) {
		super(cause);
	}
	
	

}

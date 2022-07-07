package com.crud.demo.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CountryBadRequestException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String COUNTRY_VERIFY_REQUEST_BODY = "Verify your Request Body";

	public CountryBadRequestException() {
		super();
	}

	public CountryBadRequestException(String message, Throwable cause) {
		super(message, cause);
	}

	public CountryBadRequestException(String message) {
		super(message);
	}

	public CountryBadRequestException(Throwable cause) {
		super(cause);
	}
	
	

}

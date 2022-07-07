package com.crud.demo.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ExternalResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String EXTERNAL_RESOURCE_NOT_FOUND = "Resource Not Found with endpoint: ";

	public ExternalResourceNotFoundException() {
		super();
	}

	public ExternalResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ExternalResourceNotFoundException(String message) {
		super(message);
	}

	public ExternalResourceNotFoundException(Throwable cause) {
		super(cause);
	}
	
	

}

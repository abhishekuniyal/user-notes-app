package com.gotprn.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RestClientException;

/**
Author Abhishek Uniyal
Created Date May 16, 2018
Created Time 1:08:35 PM
*/

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(GenericCustomException.class)
	protected GenericCustomException genericCustomException(GenericCustomException ex) {
		//return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
		return ex;
	}
	
	@ExceptionHandler(RestClientException.class)
	protected RestClientException restClientException(RestClientException ex) {
		//return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
		return ex;
	}
}

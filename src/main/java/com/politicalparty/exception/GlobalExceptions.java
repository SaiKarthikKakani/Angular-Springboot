package com.politicalparty.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.politicalparty.exception.model.PartyExceptionResponse;

@RestControllerAdvice
public class GlobalExceptions {

	@ExceptionHandler(InvalidPartyException.class)
	public ResponseEntity<PartyExceptionResponse> handler(InvalidPartyException ex) {
		PartyExceptionResponse exResponse = new PartyExceptionResponse(ex.getMessage(),
				System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(exResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoPartyFoundException.class)
	public ResponseEntity<PartyExceptionResponse> handler(NoPartyFoundException ex) {
		PartyExceptionResponse exResponse = new PartyExceptionResponse(ex.getMessage(),
				System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(exResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidPartyLeaderException.class)
	public ResponseEntity<PartyExceptionResponse> handler(InvalidPartyLeaderException ex) {
		PartyExceptionResponse exResponse = new PartyExceptionResponse(ex.getMessage(),
				System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(exResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoPartyLeaderFoundException.class)
	public ResponseEntity<PartyExceptionResponse> handler(NoPartyLeaderFoundException ex) {
		PartyExceptionResponse exResponse = new PartyExceptionResponse(ex.getMessage(),
				System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(exResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidDevelopmentException.class)
	public ResponseEntity<PartyExceptionResponse> handler(InvalidDevelopmentException ex) {
		PartyExceptionResponse exResponse = new PartyExceptionResponse(ex.getMessage(),
				System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(exResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoDevelopmentFoundException.class)
	public ResponseEntity<PartyExceptionResponse> handler(NoDevelopmentFoundException ex) {
		PartyExceptionResponse exResponse = new PartyExceptionResponse(ex.getMessage(),
				System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(exResponse, HttpStatus.NOT_FOUND);
	}

}

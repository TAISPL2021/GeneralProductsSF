package com.topicospl.msadmistracion.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.topicospl.msadmistracion.exception.PromocionAlreadyExistException;
import com.topicospl.msadmistracion.exception.PromocionNotFoundException;
import com.topicospl.msadmistracion.response.PromocionResponse;

@RestControllerAdvice
public class PromocionExceptionHandler {

	@ExceptionHandler(PromocionNotFoundException.class)
	public ResponseEntity<PromocionResponse> promocionNotFoundExceptionHandler(PromocionNotFoundException ex){
		var response = new PromocionResponse();
			response.setCode(String.valueOf(HttpStatus.NOT_FOUND.value()));
			response.setStatus(HttpStatus.NOT_FOUND.name());
			response.setMessage(ex.getMessage());
			
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PromocionAlreadyExistException.class)
	public ResponseEntity<PromocionResponse> promocionPromocionAlreadyExistExceptionHandler(PromocionAlreadyExistException ex){
		var response = new PromocionResponse();
			response.setCode(String.valueOf(HttpStatus.ALREADY_REPORTED.value()));
			response.setStatus(HttpStatus.ALREADY_REPORTED.name());
			response.setMessage(ex.getMessage());
			
		return new ResponseEntity<>(response,HttpStatus.ALREADY_REPORTED);
	}
}

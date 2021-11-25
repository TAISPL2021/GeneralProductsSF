package com.topicospl.msautenticacion.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.topicospl.msautenticacion.exception.RegisterGeneralException;
import com.topicospl.msautenticacion.response.AutenticacionResponse;

@RestControllerAdvice
public class RegisterGeneralExceptionHandler {

	@ExceptionHandler(RegisterGeneralException.class)
	public ResponseEntity<AutenticacionResponse> registerGeneralExceptionHandler(RegisterGeneralException ex){
		var response = new AutenticacionResponse();
		response.setCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
		response.setStatus(HttpStatus.BAD_REQUEST.name());
		response.setMessage(ex.getMessage());
		
	return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
}

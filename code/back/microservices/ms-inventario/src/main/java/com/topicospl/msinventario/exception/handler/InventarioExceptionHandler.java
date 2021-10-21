package com.topicospl.msinventario.exception.handler;

import javax.validation.UnexpectedTypeException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.topicospl.msinventario.exception.ProductoAlreadyExistException;
import com.topicospl.msinventario.exception.ProductoNotFoundException;
import com.topicospl.msinventario.response.InventarioResponse;

@RestControllerAdvice
public class InventarioExceptionHandler {

	@ExceptionHandler(ProductoNotFoundException.class)
	public ResponseEntity<InventarioResponse> productoNotFoundExceptionHandler(ProductoNotFoundException ex){
		var response = new InventarioResponse();
			response.setCode(String.valueOf(HttpStatus.NOT_FOUND.value()));
			response.setStatus(HttpStatus.NOT_FOUND.name());
			response.setMessage(ex.getMessage());
			
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ProductoAlreadyExistException.class)
	public ResponseEntity<InventarioResponse> productoAlreadyExistExceptionHandler(ProductoAlreadyExistException ex){
		var response = new InventarioResponse();
			response.setCode(String.valueOf(HttpStatus.ALREADY_REPORTED.value()));
			response.setStatus(HttpStatus.ALREADY_REPORTED.name());
			response.setMessage(ex.getMessage());
		return new ResponseEntity<>(response,HttpStatus.ALREADY_REPORTED);
	}
	
	@ExceptionHandler(UnexpectedTypeException.class)
	public ResponseEntity<InventarioResponse> UnexpectedTypeExceptionHandler(UnexpectedTypeException ex){
		var response = new InventarioResponse();
			response.setCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
			response.setStatus(HttpStatus.BAD_REQUEST.name());
			response.setMessage(ex.getMessage());
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
}

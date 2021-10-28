package com.topicospl.mscatalogo.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.topicospl.mscatalogo.response.CatalogoResponse;

@RestControllerAdvice
public class CatalogoExceptionHandler {

	@ExceptionHandler(feign.FeignException.class)
	public ResponseEntity<CatalogoResponse> productoNotFoundExceptionHandler(feign.FeignException ex){
		var response = new CatalogoResponse();
			response.setCode(String.valueOf(HttpStatus.GATEWAY_TIMEOUT.value()));
			response.setStatus(HttpStatus.GATEWAY_TIMEOUT.name());
			response.setMessage(ex.getMessage());
			
		return new ResponseEntity<>(response,HttpStatus.GATEWAY_TIMEOUT);
	}
}

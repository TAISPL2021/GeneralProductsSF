package com.topicospl.msreporte.handler;


import com.topicospl.msreporte.response.ReporteResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ReportExceptionHandler {

	@ExceptionHandler(feign.FeignException.class)
	public ResponseEntity<ReporteResponse> productoNotFoundExceptionHandler(feign.FeignException ex){
		var response = new ReporteResponse();
			response.setCode(String.valueOf(HttpStatus.GATEWAY_TIMEOUT.value()));
			response.setStatus(HttpStatus.GATEWAY_TIMEOUT.name());
			response.setMessage(ex.getMessage());
			
		return new ResponseEntity<>(response,HttpStatus.GATEWAY_TIMEOUT);
	}
}

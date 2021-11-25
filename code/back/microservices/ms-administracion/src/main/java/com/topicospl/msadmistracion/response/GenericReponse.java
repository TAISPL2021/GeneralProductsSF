package com.topicospl.msadmistracion.response;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class GenericReponse {

	private String code = String.valueOf(HttpStatus.NOT_IMPLEMENTED.value());
	private String status = String.valueOf(HttpStatus.NOT_IMPLEMENTED.name());

}

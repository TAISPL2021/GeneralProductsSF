package com.topicospl.msadmistracion.response;

import org.springframework.http.ResponseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PromocionResponse {

	private String code;
	private String status;
	private String message;
	private ResponseEntity<?> body;


}

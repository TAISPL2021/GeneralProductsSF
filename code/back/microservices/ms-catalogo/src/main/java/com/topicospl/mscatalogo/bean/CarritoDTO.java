package com.topicospl.mscatalogo.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class CarritoDTO {

	@JsonProperty("producto-id")
	private Long productoCode;
	
	@JsonProperty("producto-cantidad")
	private Long productoCantidadComprar;
}

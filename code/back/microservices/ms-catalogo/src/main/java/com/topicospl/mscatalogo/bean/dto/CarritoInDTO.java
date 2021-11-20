package com.topicospl.mscatalogo.bean.dto;

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
public class CarritoInDTO {

	@JsonProperty("userName")
	private String userName;
	
	@JsonProperty("carrito-id")
	private Long carritoId;
	
	@JsonProperty("producto-id")
	private Long productoCode;
	
	@JsonProperty("producto-nombre")
	private String productoNombre;
	
	@JsonProperty("producto-detalle")
	private String productoDetalle;
	
	@JsonProperty("producto-cantidad")
	private Long productoCantidadComprar;
}

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
	
	@JsonProperty("carrito_id")
	private Long carritoId;
	
	@JsonProperty("producto_id")
	private Long productoCode;
	
	@JsonProperty("producto_nombre")
	private String productoNombre;
	
	@JsonProperty("producto_detalle")
	private String productoDetalle;
	
	@JsonProperty("producto_cantidad")
	private Long productoCantidadComprar;
}

package com.topicosplmspagoelectronico.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

	private Long productoCode;
	
	private String productoNombre;
	
	private String productoDetalle;
	
	private Double productoPrecio;
	
	private Long productoCantidad;
	
	private Double total;
}

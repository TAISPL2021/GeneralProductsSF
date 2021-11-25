package com.topicospl.msreporte.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

	@JsonIgnore
	private Long id;
	
	private Long productoCode;
	
	private String productoNombre;
	
	private String productoDetalle;
	
	private Double productoPrecio;
	
	private Long productoCantidad;
	
	private Double total;
	
}

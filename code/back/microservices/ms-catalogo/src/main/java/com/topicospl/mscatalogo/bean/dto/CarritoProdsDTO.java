package com.topicospl.mscatalogo.bean.dto;

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
public class CarritoProdsDTO {

	private Long id;
	
	private String productoNombre;
	
	private String productoDetalle;
	
	private Long productoCantidadComprar;
}

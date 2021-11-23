package com.topicospl.msadmistracion.bean.dto;

import java.time.LocalDate;

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
	
	private Long id;
	
	private String userName;
	
	private Long carritoId;
	
	private LocalDate fechaCarrito;
	
	private Long productoCode;
	
	private String productoNombre;
	
	private String productoDetalle;
	
	private Long productoCantidadComprar;
	
}

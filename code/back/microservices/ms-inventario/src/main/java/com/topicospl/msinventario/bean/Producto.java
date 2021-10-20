package com.topicospl.msinventario.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productoId;
	private Long productoCode;
	private String productoNombre;
	private Double productoPrecio;
	private String productoDetalles;
	private Boolean productoEstado;
	private Integer productoDescuento;
	private String productoImg;
	private Date productoFechaInclusion;
	private Date productoFechaActualizacion;
	private Integer productoCantidadDisponible;
	
}

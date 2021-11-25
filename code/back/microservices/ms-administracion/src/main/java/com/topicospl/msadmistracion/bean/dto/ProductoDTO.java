package com.topicospl.msadmistracion.bean.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class ProductoDTO {

	@JsonIgnore
	private Long productoId;
	
	@JsonProperty("id")
	private Long productoCode;
	
	@JsonProperty("title")
	private String productoNombre;
	
	@JsonProperty("price")
	private Double productoPrecio;
	
	@JsonProperty("description")
	private String productoDetalles;
	
	@JsonProperty("state")
	private Boolean productoEstado;

	@JsonProperty("discount")
	private Integer productoDescuento;
	
	@JsonProperty("image")
	private String productoImg; 
	
	@JsonIgnore
	private Date productoFechaInclusion;
	
	@JsonIgnore
	private Date productoFechaActualizacion;
	
	@JsonProperty("stock")
	private Integer productoCantidadDisponible;

}

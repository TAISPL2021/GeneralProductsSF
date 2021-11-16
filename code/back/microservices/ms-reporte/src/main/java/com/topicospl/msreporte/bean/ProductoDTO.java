package com.topicospl.msreporte.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;

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
	

	private Date productoFechaInclusion;
	
	@JsonIgnore
	private Date productoFechaActualizacion;
	
	@JsonProperty("stock")
	private Integer productoCantidadDisponible;

}

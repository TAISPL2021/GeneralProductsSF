package com.topicospl.msinventario.bean.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.topicospl.msinventario.bean.Producto;

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
	
	@JsonIgnore()
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

	public ProductoDTO(Producto pro) {
		this.productoId = pro.getProductoId();
		this.productoCode = pro.getProductoCode();
		this.productoNombre = pro.getProductoNombre();
		this.productoPrecio = pro.getProductoPrecio();
		this.productoDetalles = pro.getProductoDetalles();
		this.productoEstado = pro.getProductoEstado();
		this.productoDescuento = pro.getProductoDescuento();
		this.productoImg = pro.getProductoImg();
		this.productoFechaInclusion = pro.getProductoFechaInclusion();
		this.productoFechaActualizacion = pro.getProductoFechaActualizacion();
		this.productoCantidadDisponible = pro.getProductoCantidadDisponible();
	}

}

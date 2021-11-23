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
public class CarritoFacturaGenDTO {

	@JsonProperty("factura-id")
	private String facturaNumero;
	
	@JsonProperty("factura-msg")
	private String facturaMsg;
	
	@JsonProperty("factura-resultado")
	private String facturaEstado;
}

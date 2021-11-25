package com.topicospl.mscatalogo.bean.dto;

import java.time.LocalDate;
import java.util.List;

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
public class CarritoOutDTO {

	@JsonProperty("usuario")
	private String userName;

	private LocalDate fecha;
	
	@JsonProperty("carrito_id")
	private Long carritoId;

	private List<CarritoProdsDTO> productos;
}

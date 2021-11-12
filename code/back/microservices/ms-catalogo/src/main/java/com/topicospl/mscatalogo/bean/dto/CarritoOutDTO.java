package com.topicospl.mscatalogo.bean.dto;

import java.time.LocalDate;
import java.util.Hashtable;

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

	private Hashtable<Long, CarritoProductoDTO> productos;
}
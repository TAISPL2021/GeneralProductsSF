package com.topicospl.msreporte.bean;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PromocionDTO {

	@JsonIgnore
    private Long id;
	@JsonProperty("id")
	private Long codigo;
	@JsonProperty("nombre")
	private String nombre;
	@JsonProperty("detalle")
	private String detalle;
	@JsonProperty("tipo")
	private String tipo;
	@JsonProperty("estado")
	private Boolean estado;
	@JsonProperty("porcentaje")
	private Long porcentaje;

}

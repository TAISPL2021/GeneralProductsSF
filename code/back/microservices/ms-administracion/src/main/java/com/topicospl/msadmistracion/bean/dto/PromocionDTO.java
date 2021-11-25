package com.topicospl.msadmistracion.bean.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.topicospl.msadmistracion.bean.Promocion;

import lombok.*;

@Data
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

	public PromocionDTO(Promocion promocionEntity) {
		this.id = promocionEntity.getId();
		this.codigo = promocionEntity.getCodigo();
		this.nombre = promocionEntity.getNombre();
		this.detalle = promocionEntity.getDetalle();
		this.tipo = promocionEntity.getTipo();
		this.estado = promocionEntity.getEstado();
		this.porcentaje = promocionEntity.getPorcentaje();
	}

}

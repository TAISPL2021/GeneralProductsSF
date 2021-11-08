package com.topicospl.msadmistracion.bean.dto;

import com.topicospl.msadmistracion.bean.Promocion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromocionDTO {

	private Long id;
	private Long codigo;
	private String nombre;
	private String detalle;
	private String tipo;
	private Boolean estado;
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

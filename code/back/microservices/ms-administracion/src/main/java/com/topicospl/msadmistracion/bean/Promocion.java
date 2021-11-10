package com.topicospl.msadmistracion.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.topicospl.msadmistracion.bean.dto.PromocionDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Promocion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long codigo;
	private String nombre;
	private String detalle;
	private String tipo;
	private Boolean estado;
	private Long porcentaje;
	
	public Promocion(PromocionDTO promocion){
		this.codigo = promocion.getCodigo();
		this.nombre = promocion.getNombre();
		this.detalle = promocion.getDetalle();
		this.tipo = promocion.getTipo();
		this.estado = promocion.getEstado();
		this.porcentaje = promocion.getPorcentaje();
	}
	
}

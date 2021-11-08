package com.topicospl.msadmistracion.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
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
	
}

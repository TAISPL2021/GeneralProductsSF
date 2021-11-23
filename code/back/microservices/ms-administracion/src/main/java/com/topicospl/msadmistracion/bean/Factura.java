package com.topicospl.msadmistracion.bean;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Factura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long facturaCodigo;
	
	private LocalDate facturaFecha;
	
	private String facturaNombreCliente;
	
	private String facturaCorreoCliente;
	
	private String facturaDireccionCliente;
	
	@ElementCollection()
	private List<Producto> productos;
	
	private Double facturaTotal;
}

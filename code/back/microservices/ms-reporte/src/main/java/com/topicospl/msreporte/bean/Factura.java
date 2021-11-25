package com.topicospl.msreporte.bean;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class Factura {

	private Long id;
	
	private Long facturaCodigo;
	
	private LocalDate facturaFecha;
	
	private String facturaNombreCliente;
	
	private String facturaCorreoCliente;
	
	private String facturaDireccionCliente;

	private List<Producto> productos;
	
	private Double facturaTotal;
}

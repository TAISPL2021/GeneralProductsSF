package com.topicospl.msadmistracion.bean.dto;

import java.util.List;

import com.topicospl.msadmistracion.bean.Producto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {
	
	private String estadoPedido;
	
	private String nombreCliente;
	
	private String correoCliente;
	
	private String telefonoCliente;
	
	private String direccionCliente;
	
	private List<Producto> productos;
	
}

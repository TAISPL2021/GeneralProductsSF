package com.topicospl.msadmistracion.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.topicospl.msadmistracion.bean.dto.PedidoDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String estadoPedido;
	
	private String nombreCliente;
	
	private String correoCliente;
	
	private String telefonoCliente;
	
	private String direccionCliente;
	
	@ElementCollection(targetClass = Producto.class)
	@Column(name = "lProductosOrden" )
	@Cascade(CascadeType.ALL)
	private List<Producto> productos;
	
	public Pedido(PedidoDTO pedido) {
		this.estadoPedido = pedido.getEstadoPedido();
		this.nombreCliente = pedido.getNombreCliente();
		this.correoCliente = pedido.getCorreoCliente();
		this.telefonoCliente = pedido.getTelefonoCliente();
		this.direccionCliente = pedido.getDireccionCliente();
		this.productos = pedido.getProductos();
	}
}

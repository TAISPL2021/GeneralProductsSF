package com.topicospl.mscatalogo.bean;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.topicospl.mscatalogo.bean.dto.CarritoInDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Carrito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String userName;
	
	private LocalDate fechaCarrito;
	
	private Long productoCode;
	
	private String productoNombre;
	
	private String productoDetalle;
	
	private Long productoCantidadComprar;
	
	public Carrito(CarritoInDTO carrito) {
		this.userName = carrito.getUserName();
		this.fechaCarrito = LocalDate.now();
		this.productoCode = carrito.getProductoCode();
		this.productoCantidadComprar = carrito.getProductoCantidadComprar();
		this.productoNombre = carrito.getProductoNombre();
		this.productoDetalle = carrito.getProductoDetalle();
	}
}

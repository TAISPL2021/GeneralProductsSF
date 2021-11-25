package com.topicospl.mscatalogo.service;

import org.springframework.http.ResponseEntity;

import com.topicospl.mscatalogo.bean.dto.CarritoInDTO;
import com.topicospl.mscatalogo.bean.dto.PagoDTO;

public interface ICarritoService {

	public ResponseEntity<?> statusCarrito(String userName);
	public ResponseEntity<?> incluirCarrito(CarritoInDTO carrito);
	public ResponseEntity<?> checkOutCarrito(Long carritoId, PagoDTO pago);
}

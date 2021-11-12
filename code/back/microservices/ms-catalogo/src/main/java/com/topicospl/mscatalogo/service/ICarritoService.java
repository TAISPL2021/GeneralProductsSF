package com.topicospl.mscatalogo.service;

import org.springframework.http.ResponseEntity;

import com.topicospl.mscatalogo.bean.dto.CarritoInDTO;

public interface ICarritoService {

	public ResponseEntity<?> statusCarrito(String userName);
	public ResponseEntity<?> incluirCarrito(CarritoInDTO carrito);
}

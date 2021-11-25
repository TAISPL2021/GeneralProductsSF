package com.topicospl.mscatalogo.controller.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.topicospl.mscatalogo.bean.dto.CarritoInDTO;
import com.topicospl.mscatalogo.bean.dto.PagoDTO;
import com.topicospl.mscatalogo.controller.ICarrito;
import com.topicospl.mscatalogo.service.ICarritoService;

@RestController
public class CarritoController implements ICarrito {

	@Autowired
	private ICarritoService carritoService;
	
	@Override
	public ResponseEntity<?> consultarEstadoCarrito(String userName) {
		return carritoService.statusCarrito(userName);
	}

	@Override
	public ResponseEntity<?> addProductoIntoCarrito(CarritoInDTO carrito) {
		return carritoService.incluirCarrito(carrito);
	}

	@Override
	public ResponseEntity<?> checkOutCarrito(Long carritoId, PagoDTO pagoDTO) {
		return carritoService.checkOutCarrito(carritoId, pagoDTO);
	}

}

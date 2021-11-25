package com.topicospl.mscatalogo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.topicospl.mscatalogo.bean.dto.CarritoInDTO;
import com.topicospl.mscatalogo.bean.dto.PagoDTO;

@RequestMapping("/carrito")
public interface ICarrito {

	@GetMapping("/estado/{user}")
	public ResponseEntity<?> consultarEstadoCarrito(@PathVariable("user") String user);
	
	@PostMapping("/incluir")
	public ResponseEntity<?> addProductoIntoCarrito(@RequestBody CarritoInDTO carrito);
	
	@PostMapping("/checkout/{carritoId}")
	public ResponseEntity<?> checkOutCarrito(@PathVariable("carritoId") Long carritoId, @RequestBody PagoDTO pagoDTO);
	
}

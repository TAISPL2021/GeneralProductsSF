package com.topicospl.msadmistracion.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/administracion")
public interface IAdministracionPedidoController {
	
	@GetMapping("/pedido")
	public ResponseEntity<?> checkListPedidos();
	
	@PutMapping("/pedido")
	public ResponseEntity<?> updateStatePedido();
}

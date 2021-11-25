package com.topicospl.msadmistracion.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.topicospl.msadmistracion.bean.dto.FacturaDTO;

@RequestMapping("/administracion")
public interface IAdministracionFacturaController {

	@PostMapping("/factura")
	public ResponseEntity<?> facturaGenerator (@RequestBody FacturaDTO carritoCheckOut);
	
	@GetMapping("/factura")
	public ResponseEntity<?> listFactura ();
}

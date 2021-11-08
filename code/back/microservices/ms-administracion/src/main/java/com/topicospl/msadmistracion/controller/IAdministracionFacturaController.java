package com.topicospl.msadmistracion.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/administracion")
public interface IAdministracionFacturaController {

	@PostMapping("/factura")
	public ResponseEntity<?> facturaGenerator ();
}

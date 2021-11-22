package com.topicospl.msadmistracion.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.topicospl.msadmistracion.bean.dto.CarritoDTO;

@RequestMapping("/administracion")
public interface IAdministracionFacturaController {

	@PostMapping("/factura")
	public ResponseEntity<?> facturaGenerator (@RequestBody List<CarritoDTO> carritoCheckOut);
}

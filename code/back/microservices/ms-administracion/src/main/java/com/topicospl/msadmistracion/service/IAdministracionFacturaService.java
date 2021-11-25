package com.topicospl.msadmistracion.service;

import org.springframework.http.ResponseEntity;

import com.topicospl.msadmistracion.bean.dto.FacturaDTO;

public interface IAdministracionFacturaService {

	public ResponseEntity<?> facturaGenerator(FacturaDTO carritoCheckOut);
}

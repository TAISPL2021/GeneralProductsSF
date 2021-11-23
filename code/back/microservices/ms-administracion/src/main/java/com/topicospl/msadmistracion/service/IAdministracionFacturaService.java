package com.topicospl.msadmistracion.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.topicospl.msadmistracion.bean.dto.CarritoDTO;

public interface IAdministracionFacturaService {

	public ResponseEntity<?> facturaGenerator(List<CarritoDTO> carritoCheckOut);
}

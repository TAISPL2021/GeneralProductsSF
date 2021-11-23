package com.topicospl.msadmistracion.controller.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.topicospl.msadmistracion.bean.dto.CarritoDTO;
import com.topicospl.msadmistracion.controller.IAdministracionFacturaController;
import com.topicospl.msadmistracion.service.IAdministracionFacturaService;

@RestController
public class AdministracionFacturaController implements IAdministracionFacturaController{

	@Autowired
	private IAdministracionFacturaService administracionFacturaService;
	
	@Override
	public ResponseEntity<?> facturaGenerator(List<CarritoDTO> carritoCheckOut) {
		return administracionFacturaService.facturaGenerator(carritoCheckOut);
	}

}

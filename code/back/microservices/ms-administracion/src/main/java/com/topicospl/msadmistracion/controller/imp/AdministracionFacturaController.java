package com.topicospl.msadmistracion.controller.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.topicospl.msadmistracion.bean.dto.FacturaDTO;
import com.topicospl.msadmistracion.controller.IAdministracionFacturaController;
import com.topicospl.msadmistracion.service.IAdministracionFacturaService;

@RestController
public class AdministracionFacturaController implements IAdministracionFacturaController{

	@Autowired
	private IAdministracionFacturaService administracionFacturaService;
	
	@Override
	public ResponseEntity<?> facturaGenerator(FacturaDTO carritoCheckOut) {
		return administracionFacturaService.facturaGenerator(carritoCheckOut);
	}

}

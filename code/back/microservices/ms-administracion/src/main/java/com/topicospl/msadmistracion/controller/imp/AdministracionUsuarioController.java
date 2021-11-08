package com.topicospl.msadmistracion.controller.imp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.topicospl.msadmistracion.controller.IAdministracionUsuarioController;

@RestController
public class AdministracionUsuarioController implements IAdministracionUsuarioController{
		
	@Override
	public ResponseEntity<?> usuarioConsultList() {
		return null;
	}

	@Override
	public ResponseEntity<?> usuarioControlToDisable() {
		return null;
	}
	
}

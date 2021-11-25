package com.topicospl.msadmistracion.controller.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.topicospl.msadmistracion.bean.dto.UserDTO;
import com.topicospl.msadmistracion.controller.IAdministracionUsuarioController;
import com.topicospl.msadmistracion.service.IAdministracionUsuarioService;

@RestController
public class AdministracionUsuarioController implements IAdministracionUsuarioController{
	
	@Autowired
	private IAdministracionUsuarioService administracionUsuarioService;
	
	@Override
	public ResponseEntity<?> usuarioConsultList() {
		return administracionUsuarioService.getAllUsers();
	}

	@Override
	public ResponseEntity<?> usuarioControlToDisable(UserDTO user) {
		return administracionUsuarioService.delete(user);
	}
	
}

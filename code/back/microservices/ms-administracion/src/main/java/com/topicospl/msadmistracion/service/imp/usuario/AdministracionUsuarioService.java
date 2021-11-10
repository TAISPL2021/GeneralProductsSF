package com.topicospl.msadmistracion.service.imp.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.topicospl.msadmistracion.bean.dto.UserDTO;
import com.topicospl.msadmistracion.proxy.AutenticacionProxyFeign;
import com.topicospl.msadmistracion.service.IAdministracionUsuarioService;

@Service
public class AdministracionUsuarioService implements IAdministracionUsuarioService{

	@Autowired
	private AutenticacionProxyFeign proxyAutenticacion;
	
	@Override
	public ResponseEntity<?> getAllUsers() {
		return new ResponseEntity<>(proxyAutenticacion.getAll(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> delete(UserDTO user) {
		return new ResponseEntity<>(proxyAutenticacion.delete(user),HttpStatus.OK);
	}

}

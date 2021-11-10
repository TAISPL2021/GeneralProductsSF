package com.topicospl.msadmistracion.service;

import org.springframework.http.ResponseEntity;

import com.topicospl.msadmistracion.bean.dto.UserDTO;

public interface IAdministracionUsuarioService {

	public ResponseEntity<?> getAllUsers();
	
	public ResponseEntity<?> delete(UserDTO user);
}

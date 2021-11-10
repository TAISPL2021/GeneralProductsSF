package com.topicospl.msadmistracion.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.topicospl.msadmistracion.bean.dto.UserDTO;

@RequestMapping("/administracion")
public interface IAdministracionUsuarioController {
	
	@GetMapping("/user/control")
	public ResponseEntity<?> usuarioConsultList();
	
	@PostMapping("/user/control")
	public ResponseEntity<?> usuarioControlToDisable(@RequestBody UserDTO user);

}

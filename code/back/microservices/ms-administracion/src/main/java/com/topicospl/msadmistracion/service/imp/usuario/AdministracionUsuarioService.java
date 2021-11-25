package com.topicospl.msadmistracion.service.imp.usuario;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.topicospl.msadmistracion.bean.Role;
import com.topicospl.msadmistracion.bean.RoleName;
import com.topicospl.msadmistracion.bean.dto.UserDTO;
import com.topicospl.msadmistracion.bean.dto.UserResponseDTO;
import com.topicospl.msadmistracion.proxy.AutenticacionProxyFeign;
import com.topicospl.msadmistracion.service.IAdministracionUsuarioService;


@Service
public class AdministracionUsuarioService implements IAdministracionUsuarioService{

	@Autowired
	private AutenticacionProxyFeign proxyAutenticacion;
	
	@Override
	public ResponseEntity<?> getAllUsers() {
		List<UserResponseDTO> resultReponse = new ArrayList<>();
		var listUsuarios = proxyAutenticacion.getAll();
		listUsuarios.forEach(value -> {
			System.out.println(value);
			
			Role myRole = new Role();
			myRole.setRoleName(RoleName.ADMIN);

			if (value.getRole() == null)
				value.setRole(myRole);
			
			resultReponse.add(new UserResponseDTO(value));
		});
	
		return new ResponseEntity<>(resultReponse, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> delete(UserDTO user) {
		return new ResponseEntity<>(proxyAutenticacion.delete(user),HttpStatus.OK);
	}

}

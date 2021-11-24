package com.topicospl.msadmistracion.controller.imp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.topicospl.msadmistracion.controller.IAdministracionPedidoController;

@RestController
public class AdministracionPedidoController implements IAdministracionPedidoController{

	@Override
	public ResponseEntity<?> checkListPedidos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> updateStatePedido(Long idPedido) {
		// TODO Auto-generated method stub
		return null;
	}

}

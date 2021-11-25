package com.topicospl.msadmistracion.controller.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.topicospl.msadmistracion.controller.IAdministracionPedidoController;
import com.topicospl.msadmistracion.service.IAdministracionPedidoService;

@RestController
public class AdministracionPedidoController implements IAdministracionPedidoController{

	@Autowired
	private IAdministracionPedidoService pedidoService;
	
	@Override
	public ResponseEntity<?> checkListPedidos() {
		return pedidoService.listAllPedidos();
	}

	@Override
	public ResponseEntity<?> updateStatePedido(Long idPedido) {
		return pedidoService.updateStatePedido(idPedido);
	}

}

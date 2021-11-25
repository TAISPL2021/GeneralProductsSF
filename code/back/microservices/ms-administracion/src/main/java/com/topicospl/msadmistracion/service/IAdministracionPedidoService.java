package com.topicospl.msadmistracion.service;

import org.springframework.http.ResponseEntity;

import com.topicospl.msadmistracion.bean.dto.PedidoDTO;

public interface IAdministracionPedidoService {

	public ResponseEntity<?> listAllPedidos();
	public ResponseEntity<?> updateStatePedido(Long idPedido);
	public ResponseEntity<?> createPedido(PedidoDTO pedido);
}

package com.topicospl.msadmistracion.service.imp.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.topicospl.msadmistracion.bean.Pedido;
import com.topicospl.msadmistracion.bean.dto.PedidoDTO;
import com.topicospl.msadmistracion.repository.PedidoRepository;
import com.topicospl.msadmistracion.service.IAdministracionPedidoService;

@Service
public class AdministracionPedidoService implements IAdministracionPedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Override
	public ResponseEntity<?> listAllPedidos() {
		return new ResponseEntity<>(pedidoRepository.findAll(),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> updateStatePedido(Long idPedido) {
		var tmpPedido = pedidoRepository.findById(idPedido);
		
		if(tmpPedido.isEmpty())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		tmpPedido.get().setEstadoPedido("Cerrado");
		pedidoRepository.save(tmpPedido.get());
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> createPedido(PedidoDTO pedido) {
		pedido.setEstadoPedido("Abierto");
		pedidoRepository.save(new Pedido(pedido));
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}

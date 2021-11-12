package com.topicospl.mscatalogo.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.topicospl.mscatalogo.bean.dto.CarritoInDTO;
import com.topicospl.mscatalogo.bean.dto.ProductoDTO;
import com.topicospl.mscatalogo.proxy.CatalagoProxy;
import com.topicospl.mscatalogo.response.CatalogoResponse;
import com.topicospl.mscatalogo.service.ICatalogoService;

@Service
public class CatalogoService implements ICatalogoService {
	
	@Autowired
	private CatalagoProxy proxy;

	@Override
	public ResponseEntity<List<ProductoDTO>> getListProductosFromInventario() {
		return proxy.getListProductosFromInventario();
	}

	@Override
	public ResponseEntity<List<ProductoDTO>> getListProductosFromInventarioByLike(String query) {
		return proxy.getListProductosFromInventarioByLike(query);
	}

	@Override
	public ResponseEntity<CatalogoResponse> addProductoIntoCarrito(CarritoInDTO carrito) {
		
		var response = new CatalogoResponse();
			response.setCode(String.valueOf(HttpStatus.NOT_IMPLEMENTED.value()));
			response.setStatus(HttpStatus.NOT_IMPLEMENTED.name());
			response.setMessage("Servicio No Disponible");
		
		return new ResponseEntity<>(response, HttpStatus.NOT_IMPLEMENTED);
	}

}

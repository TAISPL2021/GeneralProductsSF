package com.topicospl.mscatalogo.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.topicospl.mscatalogo.bean.ProductoDTO;
import com.topicospl.mscatalogo.proxy.CatalagoProxy;
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

}

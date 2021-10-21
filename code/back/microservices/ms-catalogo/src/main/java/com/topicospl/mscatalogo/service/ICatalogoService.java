package com.topicospl.mscatalogo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.topicospl.mscatalogo.bean.ProductoDTO;

public interface ICatalogoService {

	public ResponseEntity<List<ProductoDTO>> getListProductosFromInventario();
	public ResponseEntity<List<ProductoDTO>> getListProductosFromInventarioByLike(String query);
}

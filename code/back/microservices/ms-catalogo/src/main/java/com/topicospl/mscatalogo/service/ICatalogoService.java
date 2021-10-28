package com.topicospl.mscatalogo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.topicospl.mscatalogo.bean.CarritoDTO;
import com.topicospl.mscatalogo.bean.ProductoDTO;
import com.topicospl.mscatalogo.response.CatalogoResponse;

public interface ICatalogoService {

	public ResponseEntity<List<ProductoDTO>> getListProductosFromInventario();
	public ResponseEntity<List<ProductoDTO>> getListProductosFromInventarioByLike(String query);
	public ResponseEntity<CatalogoResponse> addProductoIntoCarrito(CarritoDTO carrito);
}

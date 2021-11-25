package com.topicospl.mscatalogo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.topicospl.mscatalogo.bean.dto.CarritoInDTO;
import com.topicospl.mscatalogo.bean.dto.ProductoDTO;
import com.topicospl.mscatalogo.response.CatalogoResponse;

public interface ICatalogoService {

	public ResponseEntity<List<ProductoDTO>> getListProductosFromInventario();
	public ResponseEntity<List<ProductoDTO>> getListProductosFromInventarioByLike(String query);
	public ResponseEntity<CatalogoResponse> addProductoIntoCarrito(CarritoInDTO carrito);
}

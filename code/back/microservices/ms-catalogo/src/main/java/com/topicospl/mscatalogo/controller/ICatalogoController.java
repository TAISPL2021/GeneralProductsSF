package com.topicospl.mscatalogo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.topicospl.mscatalogo.bean.CarritoDTO;
import com.topicospl.mscatalogo.bean.ProductoDTO;
import com.topicospl.mscatalogo.response.CatalogoResponse;

@RequestMapping("/catalogo")
public interface ICatalogoController {

	@GetMapping("/producto")
	public ResponseEntity<List<ProductoDTO>> getListProductosFromInventario();

	@GetMapping("/producto/{query}")
	public ResponseEntity<List<ProductoDTO>> getListProductosFromInventarioByLike(@PathVariable String query);

	@PostMapping("/producto")
	public ResponseEntity<CatalogoResponse> addProductoIntoCarrito(@RequestBody(required = false) CarritoDTO carrito);

}

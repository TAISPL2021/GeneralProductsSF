package com.topicospl.mscatalogo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.topicospl.mscatalogo.bean.dto.ProductoDTO;

@RequestMapping("/catalogo")
public interface ICatalogoController {

	@GetMapping("/producto")
	public ResponseEntity<List<ProductoDTO>> getListProductosFromInventario();

	@GetMapping("/producto/{query}")
	public ResponseEntity<List<ProductoDTO>> getListProductosFromInventarioByLike(@PathVariable String query);

}

package com.topicospl.msinventario.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.topicospl.msinventario.bean.dto.ProductoDTO;
import com.topicospl.msinventario.response.InventarioResponse;

public interface IProductoController {

	@GetMapping("/producto")
	public ResponseEntity<List<ProductoDTO>> findAll();
	
	@GetMapping("/producto/{query}")
	public ResponseEntity<List<ProductoDTO>> findBySearch(@PathVariable String query);
	
	@PostMapping("/producto")
	public ResponseEntity<InventarioResponse> saveProducto(@RequestBody ProductoDTO inProducto);
	
	@PatchMapping("/producto")
	public ResponseEntity<InventarioResponse> updateProducto(@RequestBody ProductoDTO inProducto);
}

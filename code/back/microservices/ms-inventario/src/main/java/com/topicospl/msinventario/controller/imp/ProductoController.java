 package com.topicospl.msinventario.controller.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.topicospl.msinventario.bean.dto.ProductoDTO;
import com.topicospl.msinventario.controller.IProductoController;
import com.topicospl.msinventario.response.InventarioResponse;
import com.topicospl.msinventario.service.IProductoService;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class ProductoController implements IProductoController {

	@Autowired
	@Qualifier("spain")
	private IProductoService productoService;

	@Override
	public ResponseEntity<List<ProductoDTO>> findAll() {
		return productoService.getAllRecords();
	}
	
	@Override
	public ResponseEntity<List<ProductoDTO>> findAllActive() {
		return productoService.getAllRecordsActive();
	}

	@Override
	public ResponseEntity<List<ProductoDTO>> findBySearch(@PathVariable String query) {
		return productoService.getRecordsBySearch(query);
	}
	
	@Override
	public ResponseEntity<?> findByCode(Long query) {
		return productoService.findByProductoCode(query);
	}

	@Override
	public ResponseEntity<InventarioResponse> saveProducto(ProductoDTO producto) {
		return productoService.saveRecord(producto);
	}

	@Override
	public ResponseEntity<InventarioResponse> updateProducto(ProductoDTO inProducto) {
		return productoService.updateRecord(inProducto);
	}

}

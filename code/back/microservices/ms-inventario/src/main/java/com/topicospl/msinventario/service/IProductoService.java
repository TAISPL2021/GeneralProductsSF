package com.topicospl.msinventario.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.topicospl.msinventario.bean.dto.ProductoDTO;
import com.topicospl.msinventario.response.InventarioResponse;

public interface IProductoService {

	public ResponseEntity<List<ProductoDTO>> getAllRecords();
	public ResponseEntity<List<ProductoDTO>> getAllRecordsActive();
	public ResponseEntity<List<ProductoDTO>> getRecordsBySearch(String querySearch);
	public ResponseEntity<InventarioResponse> saveRecord(ProductoDTO product);
	public ResponseEntity<InventarioResponse> updateRecord(ProductoDTO product);
	
	public ResponseEntity<?> findByProductoCode(Long pCode);
} 

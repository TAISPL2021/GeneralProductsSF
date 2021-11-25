package com.topicospl.msreporte.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.topicospl.msreporte.bean.ProductoDTO;

@FeignClient(name ="ms-inventario", url = "http://localhost:5200")
public interface ProductProxy {

	@GetMapping("/inventario/productos")
	public ResponseEntity<List<ProductoDTO>> getListProductosFromInventario();
}

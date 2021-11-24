package com.topicospl.msadmistracion.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.topicospl.msadmistracion.bean.dto.ProductoDTO;

@FeignClient(value = "ms-administracion" , url = "http://localhost:5200")
public interface InventarioProxyFeign {

	@GetMapping("inventario/producto/info/{query}")
	public ResponseEntity<ProductoDTO> findByCode(@PathVariable Long query);
	
}

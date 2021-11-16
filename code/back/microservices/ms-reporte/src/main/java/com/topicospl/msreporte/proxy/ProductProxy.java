package com.topicospl.msreporte.proxy;




import com.topicospl.msreporte.bean.ProductoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name ="ms-inventario", url = "http://localhost:5200")
public interface ProductProxy {

	@GetMapping("/inventario/productos")
	public ResponseEntity<List<ProductoDTO>> getListProductosFromInventario();
}

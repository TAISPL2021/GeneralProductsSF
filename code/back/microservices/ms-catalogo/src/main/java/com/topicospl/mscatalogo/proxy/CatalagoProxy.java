package com.topicospl.mscatalogo.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.topicospl.mscatalogo.bean.dto.ProductoDTO;

@FeignClient(name ="ms-inventario", url = "http://msinventario-env.eba-zs269i4q.us-east-1.elasticbeanstalk.com")
public interface CatalagoProxy {

	@GetMapping("/inventario/productos") 
	public ResponseEntity<List<ProductoDTO>> getListProductosFromInventario();
	
	@GetMapping("inventario/producto/{query}")
	public ResponseEntity<List<ProductoDTO>> getListProductosFromInventarioByLike(@PathVariable String query);
}

package com.topicospl.mscatalogo.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.topicospl.mscatalogo.bean.ProductoDTO;

@FeignClient(name ="ms-catalogo", url = "http://msinventario-env.eba-qtpvvxmm.us-east-1.elasticbeanstalk.com")
public interface CatalagoProxy {

	@GetMapping("/inventario/productos") 
	public ResponseEntity<List<ProductoDTO>> getListProductosFromInventario();
	
	@GetMapping("inventario/producto/{query}")
	public ResponseEntity<List<ProductoDTO>> getListProductosFromInventarioByLike(@PathVariable String query);
}

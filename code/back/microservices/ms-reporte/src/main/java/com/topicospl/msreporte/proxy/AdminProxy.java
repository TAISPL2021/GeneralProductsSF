package com.topicospl.msreporte.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name ="ms-administracion", url = "http://localhost:5500")
public interface AdminProxy {

	@GetMapping("/administracion/promocion")
	public ResponseEntity<?> getListPromFromInventario(@RequestHeader("filter") Boolean filter);

	@GetMapping("/administracion/factura")
	public ResponseEntity<?> listFactura ();
}

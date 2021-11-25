package com.topicospl.mscatalogo.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import com.topicospl.mscatalogo.bean.dto.FacturaDTO;

@FeignClient(name ="ms-administracion", url = "http://localhost:5500")
public interface AdministracionProxy {

	@PostMapping("/administracion/factura")
	public ResponseEntity<?> facturaGenerator (FacturaDTO carritoCheckout);
}

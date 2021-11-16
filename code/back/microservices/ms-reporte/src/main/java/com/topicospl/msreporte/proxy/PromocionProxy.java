package com.topicospl.msreporte.proxy;




import com.topicospl.msreporte.bean.ProductoDTO;
import com.topicospl.msreporte.bean.PromocionDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name ="ms-administracion", url = "http://localhost:5500")
public interface PromocionProxy {

	@GetMapping("/administracion/promocion")
	public ResponseEntity<?> getListPromFromInventario(@RequestHeader("filter") Boolean filter);
}

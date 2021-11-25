package com.topicospl.msadmistracion.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.topicospl.msadmistracion.bean.dto.PagoDTO;
import com.topicospl.msadmistracion.bean.dto.TransactionDTO;

@FeignClient(value = "ms-pagoelectronico" , url = "http://mspagoelectronico-env.eba-pz2iciie.us-east-1.elasticbeanstalk.com/")
public interface PagoElectronicoProxyFeign {

	@PostMapping(value = "pago/{uClient}")
	public ResponseEntity<TransactionDTO>  creditCardPayment(@RequestBody PagoDTO payment, @PathVariable(value = "uClient") String uClient) throws InterruptedException ;
}

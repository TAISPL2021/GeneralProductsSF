package com.topicosplmspagoelectronico.controller;


import com.topicosplmspagoelectronico.bean.Payment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/pago")
public interface IPaymentController {

	@PutMapping(value = "/{idClient}")
	public ResponseEntity<?>  creditCardPayment(@RequestBody Payment payment, @PathVariable(value = "idClient") int idClient) throws InterruptedException ;
}

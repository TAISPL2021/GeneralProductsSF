package com.topicosplmspagoelectronico.controller;


import com.topicosplmspagoelectronico.bean.dto.PaymentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/pago")
public interface IPaymentController {

	@PostMapping(value = "/{idClient}")
	public ResponseEntity<?>  creditCardPayment(@RequestBody PaymentDTO payment, @PathVariable(value = "idClient") String idClient) throws InterruptedException ;

	@GetMapping(value = "/all")
	public ResponseEntity<?>  getPayments() ;

}

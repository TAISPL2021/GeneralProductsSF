package com.topicosplmspagoelectronico.controller;

import com.payu.sdk.exceptions.ConnectionException;
import com.payu.sdk.exceptions.InvalidParametersException;
import com.payu.sdk.exceptions.PayUException;
import com.topicosplmspagoelectronico.bean.Payment;
import com.topicosplmspagoelectronico.bean.Transaction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/pago")
public interface IPaymentController {

	@PutMapping(value = "/{idClient}")
	public ResponseEntity<?>  creditCardPayment(@RequestBody Payment payment, @PathVariable(value = "idClient") int idClient) throws InvalidParametersException, PayUException, ConnectionException;
}

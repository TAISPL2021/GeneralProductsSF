package com.topicosplmspagoelectronico.controller.imp;

import com.google.inject.spi.Message;


import com.payu.sdk.exceptions.ConnectionException;
import com.payu.sdk.exceptions.InvalidParametersException;
import com.payu.sdk.exceptions.PayUException;
import com.topicosplmspagoelectronico.bean.Payment;
import com.topicosplmspagoelectronico.bean.Transaction;
import com.topicosplmspagoelectronico.controller.IPaymentController;
import com.topicosplmspagoelectronico.service.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
@RestController
public class PaymentController implements IPaymentController {


	@Autowired
	private PaymentService paymentService;

	@Override
	public ResponseEntity<?> creditCardPayment( Payment payment, int idClient) throws InvalidParametersException, PayUException, ConnectionException {
		Transaction transaction = paymentService.creditCardPayment(payment, idClient);
		return (transaction.getTransactionId().isEmpty()) ? new ResponseEntity<>(new Message("No se pudo realizar el pago"), HttpStatus.BAD_REQUEST) : new ResponseEntity<>(transaction, HttpStatus.OK);
	}

}

package com.topicosplmspagoelectronico.controller.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.google.inject.spi.Message;
import com.topicosplmspagoelectronico.bean.dto.PaymentDTO;
import com.topicosplmspagoelectronico.bean.dto.TransactionDTO;
import com.topicosplmspagoelectronico.controller.IPaymentController;
import com.topicosplmspagoelectronico.service.payment.PaymentService;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
@RestController
public class PaymentController implements IPaymentController {


	@Autowired
	private PaymentService paymentService;

	@Override
	public ResponseEntity<?> creditCardPayment(PaymentDTO payment, String idClient) throws InterruptedException  {
	 TransactionDTO transaction = paymentService.creditCardPayment(payment, idClient);
	 return (!transaction.getState().equals("OK")) ? new ResponseEntity<>(new Message("No se pudo realizar el pago"), HttpStatus.BAD_REQUEST) : new ResponseEntity<>(transaction, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getPayments() {
		List<TransactionDTO> transaction = paymentService.getAll();
		return (transaction.size()<0) ? new ResponseEntity<>(new Message("No se encontraron facturas"), HttpStatus.BAD_REQUEST) : new ResponseEntity<>(transaction, HttpStatus.OK);

	}

}

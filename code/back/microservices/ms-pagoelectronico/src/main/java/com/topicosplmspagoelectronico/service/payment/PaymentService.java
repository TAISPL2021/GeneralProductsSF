package com.topicosplmspagoelectronico.service.payment;


import com.topicosplmspagoelectronico.bean.dto.PaymentDTO;
import com.topicosplmspagoelectronico.bean.dto.TransactionDTO;

public interface PaymentService {

    TransactionDTO creditCardPayment(PaymentDTO payment, String idClient) throws InterruptedException;
}

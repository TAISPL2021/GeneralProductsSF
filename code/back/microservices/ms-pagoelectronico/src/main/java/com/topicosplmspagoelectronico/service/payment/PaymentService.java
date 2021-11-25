package com.topicosplmspagoelectronico.service.payment;


import com.topicosplmspagoelectronico.bean.Payment;
import com.topicosplmspagoelectronico.bean.Transaction;

public interface PaymentService {

    Transaction creditCardPayment(Payment payment,  int idClient) throws InterruptedException;
}

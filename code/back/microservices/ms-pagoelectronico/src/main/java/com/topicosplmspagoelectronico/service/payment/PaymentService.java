package com.topicosplmspagoelectronico.service.payment;


import com.payu.sdk.exceptions.ConnectionException;
import com.payu.sdk.exceptions.InvalidParametersException;
import com.payu.sdk.exceptions.PayUException;
import com.topicosplmspagoelectronico.bean.Payment;
import com.topicosplmspagoelectronico.bean.Transaction;

public interface PaymentService {

    Transaction creditCardPayment(Payment payment,  int idClient) throws InvalidParametersException, PayUException, ConnectionException;
}

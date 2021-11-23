package com.topicosplmspagoelectronico.service.payment.imp;



import com.payu.sdk.PayUPayments;
import com.payu.sdk.exceptions.ConnectionException;
import com.payu.sdk.exceptions.InvalidParametersException;
import com.payu.sdk.exceptions.PayUException;
import com.payu.sdk.model.TransactionResponse;
import com.topicosplmspagoelectronico.bean.Payment;
import com.topicosplmspagoelectronico.bean.Transaction;
import com.topicosplmspagoelectronico.service.payment.FillPaymentService;
import com.topicosplmspagoelectronico.service.payment.PaymentService;
import com.topicosplmspagoelectronico.service.transaction.SaveTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    SaveTransactionService saveTransactionService;
    @Autowired
    FillPaymentService savePaymentService;

    public PaymentServiceImpl(SaveTransactionService saveTransactionService, FillPaymentService savePaymentService) {
        this.saveTransactionService = saveTransactionService;
        this.savePaymentService = savePaymentService;
    }

    @Override
    public Transaction creditCardPayment( Payment payment,  int idClient) throws InvalidParametersException, PayUException, ConnectionException {
        Map<String, String> parameters;
        parameters = savePaymentService.fillMap(payment);
        //Solicitud de autorización y captura

        TransactionResponse response = transactionResponse(parameters);

        Transaction transaction = savePayment(response,payment.getId(), idClient);
        return transaction;
    }

    private TransactionResponse transactionResponse(Map<String, String> parameters) throws InvalidParametersException, PayUException, ConnectionException {
        return PayUPayments.doAuthorizationAndCapture(parameters);
    }

    private Transaction savePayment(TransactionResponse response, int idOrder, int idClient) {
        return saveTransactionService.saveTransaction(response, idOrder, idClient);
    }
}

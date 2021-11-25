package com.topicosplmspagoelectronico.service.payment.imp;


import com.topicosplmspagoelectronico.bean.Payment;
import com.topicosplmspagoelectronico.bean.Transaction;
import com.topicosplmspagoelectronico.service.payment.PaymentService;
import com.topicosplmspagoelectronico.service.transaction.SaveTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
   SaveTransactionService saveTransactionService;


    @Override
    public Transaction creditCardPayment( Payment payment,  int idClient)throws InterruptedException {
        return saveTransactionService.saveTransaction(idClient);
    }

}

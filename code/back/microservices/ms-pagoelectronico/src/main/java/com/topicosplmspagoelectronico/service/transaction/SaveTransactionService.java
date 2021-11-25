package com.topicosplmspagoelectronico.service.transaction;

import com.topicosplmspagoelectronico.bean.Transaction;
import com.topicosplmspagoelectronico.bean.dto.PaymentDTO;

public interface SaveTransactionService {

    Transaction saveTransaction(PaymentDTO payment,String idClient)throws InterruptedException;
}

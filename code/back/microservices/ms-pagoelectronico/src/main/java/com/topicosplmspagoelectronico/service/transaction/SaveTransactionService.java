package com.topicosplmspagoelectronico.service.transaction;


import com.payu.sdk.model.TransactionResponse;
import com.topicosplmspagoelectronico.bean.Transaction;

public interface SaveTransactionService {

    Transaction saveTransaction(TransactionResponse response, int orderClientId, int idClient);
}

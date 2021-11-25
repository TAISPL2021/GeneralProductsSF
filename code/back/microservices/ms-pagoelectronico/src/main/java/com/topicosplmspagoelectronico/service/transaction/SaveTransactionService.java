package com.topicosplmspagoelectronico.service.transaction;

import com.topicosplmspagoelectronico.bean.Transaction;

public interface SaveTransactionService {

    Transaction saveTransaction(int idClient)throws InterruptedException;
}

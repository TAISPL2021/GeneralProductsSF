package com.topicosplmspagoelectronico.service.transaction.imp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topicosplmspagoelectronico.bean.Transaction;
import com.topicosplmspagoelectronico.repository.TransactionRepository;
import com.topicosplmspagoelectronico.service.transaction.SaveTransactionService;

@Service
public class SaveTransactionServiceImpl implements SaveTransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public Transaction saveTransaction( String idClient) throws InterruptedException {

        @SuppressWarnings("unused")
		long start = System.currentTimeMillis();
        Thread.sleep(2000);
        Transaction transaction = new Transaction();
        transaction.setState("OK");
        transaction.setIdCliente(idClient);

        return  transactionRepository.saveAndFlush(transaction);
    }


}

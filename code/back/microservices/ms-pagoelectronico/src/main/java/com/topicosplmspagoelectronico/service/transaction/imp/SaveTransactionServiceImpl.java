package com.topicosplmspagoelectronico.service.transaction.imp;


import com.topicosplmspagoelectronico.bean.Transaction;
import com.topicosplmspagoelectronico.repository.TransactionRepository;
import com.topicosplmspagoelectronico.service.transaction.SaveTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveTransactionServiceImpl implements SaveTransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public Transaction saveTransaction( int idClient) throws InterruptedException {

        long start = System.currentTimeMillis();
        Thread.sleep(2000);
        Transaction transaction = new Transaction(idClient,"OK");
        transactionRepository.save(transaction);
        return transactionRepository.saveAndFlush(transaction);
    }


}

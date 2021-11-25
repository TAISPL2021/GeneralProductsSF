package com.topicosplmspagoelectronico.service.transaction.imp;


import com.topicosplmspagoelectronico.bean.dto.PaymentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topicosplmspagoelectronico.bean.Transaction;
import com.topicosplmspagoelectronico.repository.TransactionRepository;
import com.topicosplmspagoelectronico.service.transaction.SaveTransactionService;

import java.time.LocalDate;

@Service
public class SaveTransactionServiceImpl implements SaveTransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public Transaction saveTransaction(PaymentDTO payment,String idClient) throws InterruptedException {

        @SuppressWarnings("unused")
		long start = System.currentTimeMillis();
        Thread.sleep(2000);
        Transaction transaction = new Transaction();
        transaction.setState("OK");
        transaction.setIdCliente(idClient);
        transaction.setTotal(payment.getTotal());
        LocalDate date = LocalDate.now();
        transaction.setFecha(date);

        return  transactionRepository.saveAndFlush(transaction);
    }


}

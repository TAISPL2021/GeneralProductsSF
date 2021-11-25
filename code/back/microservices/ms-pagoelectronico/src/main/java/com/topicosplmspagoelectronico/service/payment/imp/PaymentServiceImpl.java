package com.topicosplmspagoelectronico.service.payment.imp;


import com.topicosplmspagoelectronico.bean.dto.PaymentDTO;
import com.topicosplmspagoelectronico.bean.Transaction;
import com.topicosplmspagoelectronico.bean.dto.TransactionDTO;
import com.topicosplmspagoelectronico.service.payment.PaymentService;
import com.topicosplmspagoelectronico.service.transaction.SaveTransactionService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;


@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
   SaveTransactionService saveTransactionService;
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public TransactionDTO creditCardPayment(PaymentDTO payment, int idClient)throws InterruptedException {
        Transaction transaction = saveTransactionService.saveTransaction(idClient);
        Type listType = new TypeToken<TransactionDTO>() {
        }.getType();
        TransactionDTO transactionDTO = modelMapper.map(transaction, listType);

        return transactionDTO;
    }

}

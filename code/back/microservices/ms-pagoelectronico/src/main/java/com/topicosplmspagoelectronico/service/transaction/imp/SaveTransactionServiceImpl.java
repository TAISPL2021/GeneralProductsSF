package com.topicosplmspagoelectronico.service.transaction.imp;

import com.payu.sdk.model.TransactionResponse;
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
    public Transaction saveTransaction(TransactionResponse response, int orderClientId, int idClient) {
        Transaction transaction = new Transaction();
        //Respuesta
        if (response != null) {
            transaction.setOrderClientId(orderClientId);
            transaction.setOrderId(response.getOrderId().intValue());
            transaction.setTransactionId(response.getTransactionId());
            transaction.setState(response.getState().toString());
            if (response.getState().toString().equalsIgnoreCase("PENDING")) {
                transaction.setPendingReason((response.getPendingReason() == null) ? " " : response.getPendingReason().name());
            }
            transaction.setPaymentNetworkResponse_code((response.getPaymentNetworkResponseCode() == null) ? " " : response.getPaymentNetworkResponseErrorMessage());
            transaction.setPaymentNetworkResponseErrorMessage(response.getPaymentNetworkResponseErrorMessage());
            transaction.setTrazabilityCode(response.getTrazabilityCode());
            transaction.setResponseCode(response.getResponseCode().toString());
            transaction.setErrorCode((response.getErrorCode() == null) ? " " : response.getErrorCode().getCode());
            transaction.setResponseMessage((response.getResponseMessage() == null) ? " " : response.getResponseMessage());
        }
            return transactionRepository.saveAndFlush(transaction);
    }


}

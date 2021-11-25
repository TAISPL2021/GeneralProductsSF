package com.topicosplmspagoelectronico.service.payment;


import com.topicosplmspagoelectronico.bean.dto.PaymentDTO;
import com.topicosplmspagoelectronico.bean.dto.TransactionDTO;

import java.util.List;

public interface PaymentService {

    TransactionDTO creditCardPayment(PaymentDTO payment, String idClient) throws InterruptedException;

   List<TransactionDTO> getAll();
}

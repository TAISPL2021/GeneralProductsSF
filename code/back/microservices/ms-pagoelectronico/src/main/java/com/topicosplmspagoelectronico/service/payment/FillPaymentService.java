package com.topicosplmspagoelectronico.service.payment;


import com.topicosplmspagoelectronico.bean.Payment;

import java.util.Map;

public interface FillPaymentService {

     Map<String, String> fillMap(Payment payment);
}

package com.topicosplmspagoelectronico.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data

public class Transaction {

    private int id;
    private int orderClientId;
    private int orderId;
    private String transactionId;
    private String state;
    private String paymentNetworkResponse_code;
    private String paymentNetworkResponseErrorMessage;
    private String trazabilityCode;
    private String authorizationCode;
    private String pendingReason;
    private String responseCode;
    private String errorCode;
    private String responseMessage;
    private String transactionType;
}

package com.topicosplmspagoelectronico.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class CreditCard {
    private int id;
    private String cardNumber;
    private String expirationDate;
    private String paymentMethod;
    private String securityCode;
}


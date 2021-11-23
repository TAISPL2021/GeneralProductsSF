package com.topicosplmspagoelectronico.bean;


import lombok.Data;

@Data
public class Payment {

    private int id;
    private Client client;
    private String phone;
    private String street;
    private String street2;
    private String city;
    private String state;
    private String postalCode;
    private CreditCard creditCard;
    private int paymentValue;
}

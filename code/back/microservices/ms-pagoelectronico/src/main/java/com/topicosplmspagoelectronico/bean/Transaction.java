package com.topicosplmspagoelectronico.bean;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String idCliente;
    private String state;

    public Transaction(String idCliente, String state) {
        this.idCliente = idCliente;
        this.state = state;
    }
}

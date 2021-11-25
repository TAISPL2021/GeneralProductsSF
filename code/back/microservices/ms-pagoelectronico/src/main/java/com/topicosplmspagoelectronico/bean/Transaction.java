package com.topicosplmspagoelectronico.bean;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

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
    private LocalDate fecha;
    private Double total;

    public Transaction(String idCliente, String state) {
        this.idCliente = idCliente;
        this.state = state;
    }
}

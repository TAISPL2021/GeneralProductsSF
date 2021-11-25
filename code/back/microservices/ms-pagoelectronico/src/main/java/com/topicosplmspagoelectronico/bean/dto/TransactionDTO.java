package com.topicosplmspagoelectronico.bean.dto;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TransactionDTO {
    private Long id;
    private String idCliente;
    private String state;
    private LocalDate fecha;
    private Double total;
}

package com.topicosplmspagoelectronico.bean.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TransactionDTO {
    private Long id;
    private int idCliente;
    private String state;
}

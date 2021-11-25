package com.topicospl.msadmistracion.bean.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TransactionDTO {
    private Long id;
    private String idCliente;
    private String state;
}

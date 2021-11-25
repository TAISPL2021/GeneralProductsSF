package com.topicosplmspagoelectronico.bean.dto;


import lombok.Data;

@Data
public class PaymentDTO {

    private String NombreTarjeta;
    private String numeroTarjeta;
    private String FechaExpiracion;
    private String NumeroDeVerificacion;
    private Long cuotas;
    private Double total;

}

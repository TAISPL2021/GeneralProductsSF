package com.topicosplmspagoelectronico.bean;


import lombok.Data;

@Data
public class Payment {

    private String NombreTarjeta;
    private String numeroTarjeta;
    private String FechaExpiracion;
    private String NumeroDeVerificacion;
    private int cuotas;
    private int total;

}

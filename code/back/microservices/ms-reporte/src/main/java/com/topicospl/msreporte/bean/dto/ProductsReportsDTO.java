package com.topicospl.msreporte.bean.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductsReportsDTO {
    private Long productoCode;
    private String productoNombre;
    private Double productoPrecio;
    private String productoDetalles;
    private Boolean productoEstado;
    private Integer productoCantidadDisponible;
    private Integer productoDescuento;
}

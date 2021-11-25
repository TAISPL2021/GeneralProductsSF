package com.topicospl.msreporte.bean.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Data
public class OrdersReportDTO {

    private Long facturaCodigo;
    private LocalDate facturaFecha;
    private String facturaNombreCliente;
    private Double priceProducto;
    private Long productId;
    private String nombreProduct;
    private Integer cantidad;
    private Double facturaTotal;

}

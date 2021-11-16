package com.topicospl.msreporte.bean.dto;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PromReportsDTO {
    private Long id;
    private String nombre;
    private Boolean estado;
    private String tipo;
    private Long porcentaje;

}

package com.topicospl.mscatalogo.bean.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PagoDTO {

	private String numeroTarjeta;
	private String NombreTarjeta;
	private String FechaExpiracion;
	private String NumeroDeVerificacion;
	private Long cuotas;
	private String userName;
	
}

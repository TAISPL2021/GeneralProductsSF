package com.topicospl.msadmistracion.bean.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class FacturaDTO {

	private PagoDTO pagoDTO;
	private List<CarritoDTO> carritoCheckOut;
}

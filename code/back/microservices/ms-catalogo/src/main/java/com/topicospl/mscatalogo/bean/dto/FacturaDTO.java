package com.topicospl.mscatalogo.bean.dto;

import java.util.List;

import com.topicospl.mscatalogo.bean.Carrito;

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
	private List<Carrito> carritoCheckOut;
}

package com.topicospl.msadmistracion.service.imp.factura;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.topicospl.msadmistracion.bean.Producto;
import com.topicospl.msadmistracion.bean.dto.CarritoDTO;
import com.topicospl.msadmistracion.proxy.InventarioProxyFeign;
import com.topicospl.msadmistracion.service.IAdministracionFacturaService;

@Service
public class AdministracionFacturaService implements IAdministracionFacturaService{

	@Autowired
	private InventarioProxyFeign inventarioProxyFeign;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public ResponseEntity<?> facturaGenerator(List<CarritoDTO> carritoCheckOut) {
		var listProducts = new ArrayList<Producto>();
		
		carritoCheckOut.forEach(value -> {
			var productPrice = inventarioProxyFeign.findByCode(value.getProductoCode()).getBody();
			System.out.println(productPrice);
			
			var tmpProduct = new Producto(); 
				tmpProduct.setProductoCode(value.getProductoCode());
				tmpProduct.setProductoNombre(value.getProductoNombre());
				tmpProduct.setProductoDetalle(value.getProductoDetalle());
			
			listProducts.add(tmpProduct);
		});
		 
		return null;
	}

}
